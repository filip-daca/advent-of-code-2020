import utils.SimpleReader

def lines = SimpleReader.readInput()

int x = 0
int y = 0
int dir = 0
def directions = ["E", "S", "W", "N"]

lines.each {
    String command = it[0]
    int value = it.substring(1).toInteger()

    if (command == "R") {
        dir = (dir + (value / 90).toInteger()) % 4
    } else if (command == "L") {
        dir = (dir - (value / 90).toInteger()) % 4
    } else {

        if (command == "F") {
            command = directions[dir]
        }

        switch (command) {
            case "N": y-= value; break
            case "S": y+= value; break
            case "W": x-= value; break
            case "E": x+= value; break
        }
    }


}

println "x = $x y = $y dist = ${Math.abs(x) + Math.abs(y)}"
