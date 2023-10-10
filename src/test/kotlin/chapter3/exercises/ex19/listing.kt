package chapter3.exercises.ex19

import chapter3.List
import chapter3.List.Companion.empty
import chapter3.append
import chapter3.foldLeft
import chapter3.foldRight
import chapter5.sec1.a
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec
import utils.SOLUTION_HERE

// tag::init[]
fun <A, B> flatMap(xa: List<A>, f: (A) -> List<B>): List<B> =
    foldLeft(xa, empty(), {b: List<B>, a: A  ->  append(b, f(a)) })
    // foldRight(xa, empty(), {a: A, b: List<B> ->  append(f(a), b) })

// end::init[]

//TODO: Enable tests by removing `!` prefix
class Exercise19 : WordSpec({
    "list flatmap" should {
        "map and flatten a list" {
            val xs = List.of(1, 2, 3)
            flatMap(xs) { i -> List.of(i, i) } shouldBe
                List.of(1, 1, 2, 2, 3, 3)
        }
    }
})
