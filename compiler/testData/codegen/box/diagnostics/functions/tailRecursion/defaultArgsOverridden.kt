open class A {
    open fun foo(s: String = "OK") = s
}

class B : A() {
    <!NO_TAIL_CALLS_FOUND!>override tailrec fun foo(s: String): String<!> {
        return if (s == "OK") s else foo()
    }
}

fun box() = B().foo("FAIL")