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
            } else if (map[y][x] == "#" && countPeopleAround(x, y, map) >= 5) {
                newMap[y][x] = "L"
                changed = true
            }
        }
    }

    map = newMap
}

println map.flatten().findAll { it == "#" }.size()

int countPeopleAround(x, y, map) {
    return countPeople(x, y, { a, b -> [a - 1, b - 1] }, map) +
            countPeople(x, y, { a, b -> [a - 1, b] }, map) +
            countPeople(x, y, { a, b -> [a - 1, b + 1] }, map) +
            countPeople(x, y, { a, b -> [a, b - 1] }, map) +
            countPeople(x, y, { a, b -> [a, b + 1] }, map) +
            countPeople(x, y, { a, b -> [a + 1, b - 1] }, map) +
            countPeople(x, y, { a, b -> [a + 1, b] }, map) +
            countPeople(x, y, { a, b -> [a + 1, b + 1] }, map)
}

int countPeople(x, y, modifier, map) {
    (x, y) = modifier(x, y)
    while (y >= 0 && y < map.size() && x >= 0 && x < map[y].size() && map[y][x] == ".") {
        (x, y) = modifier(x, y)
    }
    y >= 0 && y < map.size() && x >= 0 && x < map[y].size() && map[y][x] == "#" ? 1 : 0
}
