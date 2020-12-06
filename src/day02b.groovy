import utils.SimpleReader

def items = SimpleReader.readInput()

def valid = 0

items.each { it ->
    def match = (it =~ /(\d*)-(\d*) (.): (.+)/)
    def i1 = match[0][1].toInteger() - 1
    def i2 = match[0][2].toInteger() - 1
    def character = match[0][3]
    def password = match[0][4]

    if ((password[i1] == character && password[i2] != character)
            || (password[i1] != character && password[i2] == character)) {
        valid++
    }
}

println "Valid passwords: ${valid}"
