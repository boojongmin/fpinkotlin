package chapter3

fun <A, B> foldRight(xs: List<A>, z: B, f: (A, B) -> B): B {
    return when (xs) {
        is Nil -> {
            println("> $z\t")
            z
        }
        is Cons -> {
            val r = f(xs.head, foldRight(xs.tail, z, f))
            println("> ${xs.head}\t$r\t")
            r
        }
    }
}

tailrec fun <A, B> foldLeft(xs: List<A>, z: B, f: (B, A) -> B): B =
    when (xs) {
        is Nil -> {
            println("$z")
            z
       }
        is Cons ->  {
            val r = foldLeft(xs.tail, f(z, xs.head), f)
            println("> ${xs.head}: $r")
            r
        }
    }

fun <A, B> foldLeftR(xs: List<A>, z: B, f: (B, A) -> B): B =
    foldRight(
        xs,
        { b: B -> b },
        { a, g ->
            { b ->
                g(f(b, a))
            }
        })(z)

fun <A, B> foldRightL(xs: List<A>, z: B, f: (A, B) -> B): B =
    foldLeft(xs,
        { b: B -> b },
        { g, a ->
            { b ->
                g(f(a, b))
            }
        })(z)

fun <A, B> flatMap(xa: List<A>, f: (A) -> List<B>): List<B> =
    foldRight(
        xa,
        List.empty(),
        { a, lb ->
            append(f(a), lb)
        })

fun <A> reverse(xs: List<A>): List<A> =
    foldLeft(xs, List.empty(), { t: List<A>, h: A -> Cons(h, t) })

fun <A> append(a1: List<A>, a2: List<A>): List<A> =
    foldRight(a1, a2, { x, y -> Cons(x, y) })
