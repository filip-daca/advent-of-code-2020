import utils.SimpleReader

def items = SimpleReader.readInput().collect { it.toInteger() }

for(int a in 0..<items.size) {
    for(b in a+1..<items.size) {
        if (items[a] + items[b] == 2020) {
            println "${items[a]} * ${items[b]} = ${items[a] * items[b]}"
        }
    }
}
