import utils.SimpleReader

def items = SimpleReader.readInput()

def x = 0
def len = items[0].size()
def count = 0

items.each { line ->
    if (line[x] == "#") {
        count++
    }
    x = (x + 3) % len
}

println "Encountered $count trees"
