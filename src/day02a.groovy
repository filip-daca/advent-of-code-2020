import utils.SimpleReader

def items = SimpleReader.readInput()

def valid = 0

items.each { it ->
    def match = (it =~ /(\d*)-(\d*) (.): (.+)/)
    def min = match[0][1].toInteger()
    def max = match[0][2].toInteger()
    def character = match[0][3]
    def password = match[0][4]

    def result = password.findAll { c ->
        c == character
    }.size

    if (result in min..max) {
        valid++
    }
}

println "Valid passwords: ${valid}"
