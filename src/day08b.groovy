import utils.SimpleReader

def lines = SimpleReader.readInput() as ArrayList

def commands = lines.collect {
    def command = it.split(" ")
    [command[0], command[1].toInteger()]
}

commands.findIndexValues { command ->
    command[0] == "nop" || command[0] == "jmp"
}.each { indexToSwap ->
    toggle(commands, indexToSwap)

    def runResult = simulate(commands)
    if (runResult[0]) {
        println runResult[1]
    }
    toggle(commands, indexToSwap)
}

def toggle(commands, indexToSwap) {
    if (commands[indexToSwap][0] == "nop") {
        commands[indexToSwap][0] = "jmp"
    } else {
        commands[indexToSwap][0] = "nop"
    }
}

def simulate(List commands) {
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

        end = visited.contains(i) || i >= commands.size()
    }

    [i >= commands.size(), accumulator]
}


