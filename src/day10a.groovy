import utils.SimpleReader

List<Long> adapters = SimpleReader.readInput().collect{ it.toLong() }.sort()

int i = 0
long prevVal = 0

int diff1 = 0
int diff3 = 0

while (i < adapters.size()) {
    def diff = adapters[i] - prevVal
    if (diff == 1) {
        diff1++
    } else if (diff == 3) {
        diff3++
    }
    prevVal = adapters[i]
    i++
}
diff3++

println "Diff1 = $diff1 and Diff3 = $diff3 and Diff1*Diff3 = ${diff1 * diff3}"

