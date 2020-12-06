import utils.SimpleReader

def items = SimpleReader.readInput()
def requiredFields = [
        "byr:",
        "iyr:",
        "eyr:",
        "hgt:",
        "hcl:",
        "ecl:",
        "pid:"
]

def validCount = 0

static boolean isPassportValid(requiredFields, String passport) {
    boolean hasAll = true;
    requiredFields.each {
        hasAll = hasAll && passport.contains(it)
    }

    hasAll
}

def passport = ""
items.each { line ->
    passport = passport + line
    if (line == "") {
        if (isPassportValid(requiredFields, passport)) {
            validCount++
        }
        passport = ""
    }
}
if (isPassportValid(requiredFields, passport)) {
    validCount++
}

println "Found $validCount valid passports"
