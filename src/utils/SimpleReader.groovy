package utils

class SimpleReader {

    static def readInput() {
        def reader = System.in.newReader()
        def lines = reader.readLines()
    }

    static def readGroups() {
        def items = readInput()

        items.inject([]) { group, line ->
            if (line == "") {
                [[]] + group
            } else if (group == []) {
                [[line]]
            } else {
                [group.head() + line]  + group.tail()
            }
        }.reverse()
    }
}
