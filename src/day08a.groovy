import utils.SimpleReader

def lines = SimpleReader.readInput() as ArrayList

def commands = lines.collect {
    def command = it.split(" ")
    [command[0], command[1].toInteger()]
}

def accumulator = 0
def i = 0
def visited = [] as Set
def end = false

while (!end) {
    visited.add(i)

    if (commands[i][0] == "acc") {
        accumulator += commands[i][1]
    }

    if (commands[i][0] == "jmp") {
        i += commands[i][1]
    } else {
        i++
    }

    end = visited.contains(i)
}

println accumulator
