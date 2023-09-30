package chapter3.exercises.ex14

import chapter3.Cons
import chapter3.List
import chapter3.List.Companion.empty
import chapter3.Nil
import chapter3.append
import chapter3.foldRight
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec
import utils.SOLUTION_HERE

// tag::init[]
fun <A> concat(lla: List<List<A>>): List<A> =
    foldRight(lla, empty(), {a1, b1 -> foldRight(a1, b1, {a2, b2 -> Cons(a2, b2)}) })

fun <A> concat2(lla: List<List<A>>): List<A> =
    foldRight(lla, empty(), {a1: List<A>, b1: List<A> -> append(a1, b1)})

// end::init[]

//TODO: Enable tests by removing `!` prefix
class Exercise14 : WordSpec({
    "list concat" should {
        "concatenate a list of lists into a single list" {
            concat(
                List.of(
                    List.of(1, 2, 3),
                    List.of(4, 5, 6)
                )
            ) shouldBe List.of(1, 2, 3, 4, 5, 6)

            concat2(
                List.of(
                    List.of(1, 2, 3),
                    List.of(4, 5, 6)
                )
            ) shouldBe List.of(1, 2, 3, 4, 5, 6)
        }
    }
})
