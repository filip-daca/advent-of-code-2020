import utils.SimpleReader

def lines = SimpleReader.readInput()

def myTime = lines[0].toLong()

def busIds = lines[1].split(",")
        .findAll { it != "x" }
        .collect { it.toLong() }


def waitTime = busIds.collect { id ->
    id - (myTime % id)
}

def minWaitTime = myTime
def minBusId = 0
for (int i in 0..<busIds.size()) {
    if (minWaitTime > waitTime[i]) {
        minWaitTime = waitTime[i]
        minBusId = busIds[i]
    }
}

println "minWaitTime: $minWaitTime, minBusId: $minBusId, multiply = ${minWaitTime * minBusId}"
