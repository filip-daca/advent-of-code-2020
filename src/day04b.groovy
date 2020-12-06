import utils.SimpleReader

def items = SimpleReader.readInput()
def requiredFields = [
        /.*byr:(19[2-9]\d|200[0-2]) .*/,
        /.*iyr:(201\d|2020) .*/,
        /.*eyr:(202\d|2030) .*/,
        /.*hgt:(1([5-8]\d|9[0-3])cm|(59|6\d|7[0-6])in) .*/,
        /.*hcl:#[a-f0-9]{6} .*/,
        /.*ecl:(amb|blu|brn|gry|grn|hzl|oth) .*/,
        /.*pid:\d{9} .*/
]

def validCount = 0

static boolean isPassportValid(requiredFields, String passport) {
    boolean hasAll = true;
    requiredFields.each {
        hasAll = hasAll && passport.matches(it)
    }

    hasAll
}

def passport = ""
items.each { line ->
    passport = passport + " " + line
    if (line == "") {
        if (isPassportValid(requiredFields, passport)) {
            println passport
            validCount++
        }
        passport = ""
    }
}
if (isPassportValid(requiredFields, passport)) {
    println passport
    validCount++
}

println "Found $validCount valid passports"
