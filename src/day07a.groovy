import utils.SimpleReader

def lines = SimpleReader.readInput()

final def PARENT_COLOR_REG = /(.+) bags contain /
final def CHILDREN_COLOR_REG = /(\d+) (.+?) bags?[,.]/
final def MY_COLOR = "shiny gold"

boolean canCarry(String color, knownBags, final MAPS, final String MY_COLOR) {
    if (knownBags.containsKey(color)) {
        return knownBags.get(color)
    } else {
        def result
        if (color == MY_COLOR) {
            result = true
        } else if (MAPS.get(color) == []) {
            result = false
        } else {
            result = MAPS.get(color).inject(false) { found, childColor ->
                found || canCarry(childColor, knownBags, MAPS, MY_COLOR)
            }
        }
        knownBags.put(color, result)
        return result
    }
}

def maps = lines.inject([:]) { map, line ->
    def color = (line =~ PARENT_COLOR_REG)[0][1]
    def colors = (line =~ CHILDREN_COLOR_REG).collect {
        it[2]
    }
    map + [(color): colors]
}


Map knownBags = [:]
maps.each { k, v ->
    canCarry(k, knownBags, maps, MY_COLOR)
}

println knownBags.findAll {it.value }.size() - 1
