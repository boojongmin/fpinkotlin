package chapter3

import chapter5.sec1.a

sealed class List<out A> {
    companion object {
        tailrec fun <A> of(vararg aa: A): List<A> {
            val tail = aa.sliceArray(1 until aa.size)
            return if (aa.isEmpty()) {
               // println("\t Nil")
               Nil
            }  else {
                // print("\t ${aa[0]}")
                Cons(aa[0], of(*tail))
            }
        }

        fun <A> empty(): List<A> = Nil
    }

    tailrec fun <A, B> foldLeft(xs: List<A>, z: B, f: (B, A) -> B): B {
        return when (xs) {
            is Nil -> {
                // println("$z")
                z
            }
            is Cons -> {
                // println("> ${xs.head} \t")
                foldLeft(xs.tail, f(z, xs.head), f)
            }
        }
    }


    fun reverse(): List<A> =
        foldLeft(this, empty(), { t: List<A>, h: A -> Cons(h, t) })
}

object Nil : List<Nothing>() {
    override fun toString(): String = "Nil"
}

data class Cons<out A>(val head: A, val tail: List<A>) : List<A>()
