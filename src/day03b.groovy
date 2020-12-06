import utils.SimpleReader

static def countTreesOnSlope(List<String> items, int speedRight, int speedDown) {
    def x = 0
    def len = items[0].size()
    def count = 0

    int y = 0
    while (y < items.size()) {
        def line = items[y]
        if (line[x] == "#") {
            count++
        }
        x = (x + speedRight) % len
        y += speedDown
    }

    count
}

def items = SimpleReader.readInput()

def results = [
        countTreesOnSlope(items, 1, 1),
        countTreesOnSlope(items, 3, 1),
        countTreesOnSlope(items, 5, 1),
        countTreesOnSlope(items, 7, 1),
        countTreesOnSlope(items, 1, 2)
]

println results
println "Encountered ${results.sum()} trees"
println "This results in ${results.collect {it.toBigInteger()}.inject { acc, val -> acc * val }}"

