package utils

class MultiSet {

    Map m = [:]

    void add(v) {
        if (m[v]) {
            m[v]++
        } else {
            m[v] = 1
        }
    }

    void remove(v) {
        m[v]--
    }

    boolean contains(v) {
        m[v] > 0
    }
}
