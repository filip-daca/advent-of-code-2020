import utils.SimpleReader

def lines = SimpleReader.readInput()

def busIds = []

long i = 0
lines[0].split(",").each {
    if (it != "x") {
        busIds << [it.toLong(), i]
    }
    i++
}

println busIds


println busIds.tail().inject([busIds[0][0], busIds[0][1]]) { prev, it ->
    println "doing ... ${prev[1]}"
    [prev[0] * it[0], findForPair(prev[0], it[0], prev[1], it[1])]
}[1]


long findForPair(long id1, long id2, long diff1, long diff2) {
    boolean found = false
    long timestamp = diff1

    long diff = id2 - (diff2 % id2)

    while (!found) {
        def rest = timestamp % id2
        found = rest == diff
        timestamp += id1
    }

    return timestamp - id1
}
