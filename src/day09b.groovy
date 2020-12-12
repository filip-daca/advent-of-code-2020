import utils.SimpleReader

final Integer RESULT = 138879426

List<Long> numbers = SimpleReader.readInput().collect{ it.toLong() }

long sum = numbers[0]
int a = 0
int b = 0

while (sum != RESULT && b < numbers.size() && a < numbers.size()) {
    while (sum < RESULT) {
        b++
        sum += numbers[b]
    }

    if (sum > RESULT) {
        sum -= numbers[a]
        a++
    }
}

def span = ((a..b).collect {numbers[it] })
println span.min() + span.max()
