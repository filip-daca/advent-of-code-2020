import utils.SimpleReader

def groups = SimpleReader.readGroups()

def count = 0
groups.each { group ->
    def allTrue = [] as Set
    allTrue.addAll(group.head().toList())

    group.tail().each { line ->
        allTrue = allTrue.findAll { answer ->
            line.contains(answer)
        }
    }

    count += allTrue.size()
}

println "All true matching answers = $count"
