package chapter3.exercises.ex9

import chapter3.Cons
import chapter3.List
import chapter3.Nil
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec
import utils.SOLUTION_HERE

// tag::init[]
// tailrec fun foldLeft(xs: List<Int>, z: Int, f: (Int, Int) -> Int): Int =
//     when(xs) {
//         is Nil -> z
//         is Cons -> foldLeft(xs.tail, f(z, xs.head), f)
//     }

tailrec fun <A, B> foldLeft(xs: List<A>, z: B, f: (B, A) -> B): B =
    when(xs) {
        is Nil -> z
        is Cons -> foldLeft(xs.tail, f(z, xs.head), f)
    }

// end::init[]

//TODO: Enable tests by removing `!` prefix
class Exercise9 : WordSpec({
    "list foldLeft" should {
        """apply a function f providing a zero accumulator from tail
            recursive position""" {
            // val arr: Array<Int> = (0..9999).toList().toIntArray().toTypedArray()
            val xs = List.of(0, 1, 2, 3,  4, 5)
            foldLeft(
                xs,
                0,
                // { x, y -> x + y }) shouldBe 20
            { x, y -> x + y }) shouldBe 15
        }
    }
})
