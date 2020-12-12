import utils.MultiSet
import utils.SimpleReader

final Integer PAD = 25

List<Long> numbers = SimpleReader.readInput().collect{ it.toLong() }

def allowedSums = new MultiSet()

for (int a = 0; a < PAD; a++) {
    for (int b = a + 1; b < PAD; b++) {
        allowedSums.add(numbers[a] + numbers[b])
    }
}

int i = PAD
while (allowedSums.contains(numbers[i])) {
    for (int a = 1; a < PAD; a++) {
        allowedSums.remove(numbers[i - PAD] + numbers[i - PAD + a])
    }

    for (int a = 1; a < PAD; a++) {
        allowedSums.add(numbers[i] + numbers[i - a])
    }

    i++
}

println (numbers[i])
