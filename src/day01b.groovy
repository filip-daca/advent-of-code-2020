import utils.SimpleReader

def items = SimpleReader.readInput().collect { it.toInteger() }

for(int a in 0..<items.size) {
    for(b in a+1..<items.size) {
        for(c in b+1..<items.size) {
            if (items[a] + items[b] + items[c] == 2020) {
                println "${items[a]} * ${items[b]} * ${items[c]} = ${items[a] * items[b] * items[c]}"
            }
        }
    }
}
