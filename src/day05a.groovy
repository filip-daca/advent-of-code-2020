import utils.SimpleReader

def calculateSeatId(String code) {
    def l = 0
    def r = 7
    def f = 0
    def b = 127

    code.each {
        switch (it) {
            case "F":
                b -= (b-f).intdiv(2) + 1
                break
            case "B":
                f += (b-f).intdiv(2) + 1
                break
            case "L":
                r -= (r-l).intdiv(2) + 1
                break
            case "R":
                l += (r-l).intdiv(2) + 1
                break
        }
    }

    f * 8 + l
}

def items = SimpleReader.readInput()

List seatIds = items.collect {
    calculateSeatId(it)
}

println "max seat id: ${seatIds.max()}"
