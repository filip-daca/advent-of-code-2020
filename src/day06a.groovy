import utils.SimpleReader

def items = SimpleReader.readInput()

def count = 0
def answers = [] as Set
items.each { line ->
    answers += line.toList()
    if (line == "") {
        count += answers.size()
        answers = [] as Set
    }
}
count += answers.size()

println "Found $count answers"
