import utils.SimpleReader

def lines = SimpleReader.readInput()

int x = 0
int y = 0

int wx = 10
int wy = -1

lines.each {
    String command = it[0]
    int value = it.substring(1).toInteger()

    if (command == "R") {
        def rotations = (value / 90).toInteger() % 4
        for (int i = 0; i < rotations; i++) {
            (wx, wy) = [-wy, wx]
        }
    } else if (command == "L") {
        def rotations = (value / 90).toInteger() % 4
        for (int i = 0; i < rotations; i++) {
            (wx, wy) = [wy, -wx]
        }
    } else if (command == "F") {
        x += wx * value
        y += wy * value
    } else {
        switch (command) {
            case "N": wy -= value; break
            case "S": wy += value; break
            case "W": wx -= value; break
            case "E": wx += value; break
        }
    }

    println  "x = $x y = $y"
}

println "x = $x y = $y dist = ${Math.abs(x) + Math.abs(y)}"
