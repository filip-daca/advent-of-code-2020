import utils.SimpleReader

def lines = SimpleReader.readInput()

def map = lines.inject([]) { m, line ->
    m << line.toList()
}

def rounds = 0
def changed = true
while (changed) {
    changed = false
    rounds++
    def newMap = map.inject([]) { m, line ->
        m << line.clone()
    }

    for (int y = 0; y < map.size(); y++) {
        for (int x = 0; x < map[y].size(); x++) {
            if (map[y][x] == "L" && countPeopleAround(x, y, map) == 0) {
                newMap[y][x] = "#"
                changed = true
            } else if (map[y][x] == "#" && countPeopleAround(x, y, map) >= 4) {
                newMap[y][x] = "L"
                changed = true
            }
        }
    }

    map = newMap
}

println map.flatten().findAll { it == "#" }.size()

int countPeopleAround(x, y, map) {
    def sum = 0
    for (int a = x-1; a <= x+1; a++)
        for (int b = y-1; b <= y+1; b++)
            if (a != x || b != y) {
                sum += countPeople(a, b, map)
            }
    sum
}

int countPeople(x, y, map) {
    y >= 0 && y < map.size() && x >= 0 && x < map[y].size() && map[y][x] == "#" ? 1 : 0
}
