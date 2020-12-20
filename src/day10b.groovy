import utils.SimpleReader

ALLOWED_DIFF = 3

List<Long> adapters = SimpleReader.readInput().collect { it.toLong() }.sort()
adapters = [0] + adapters + [adapters.last() + 3]

def combinations = new long[adapters.size()]
combinations[0] = 1
def i = 1

while (i < adapters.size()) {
    combinations[i] = combinations[i-1]

    if (i > 1 && adapters[i] - adapters[i-2] <= ALLOWED_DIFF) {
        combinations[i] += combinations[i-2]
    }

    if (i > 2 && adapters[i] - adapters[i-3] <= ALLOWED_DIFF) {
        combinations[i] += combinations[i-3]
    }

    i++
}

println combinations[combinations.size() - 1]
