import utils.SimpleReader

def lines = SimpleReader.readInput()

final def PARENT_COLOR_REG = /(.+) bags contain /
final def CHILDREN_COLOR_REG = /(\d+) (.+?) bags?[,.]/
final def MY_COLOR = "shiny gold"

int countBagsInside(color, MAPS) {
    MAPS.get(color).inject(0) { sum, childBag ->
        sum + childBag[0] * (1 + countBagsInside(childBag[1], MAPS))
    }
}

def maps = lines.inject([:]) { map, line ->
    def color = (line =~ PARENT_COLOR_REG)[0][1]
    def colors = (line =~ CHILDREN_COLOR_REG).collect {
        [it[1].toInteger(), it[2]]
    }
    map + [(color): colors]
}


println countBagsInside(MY_COLOR, maps)
