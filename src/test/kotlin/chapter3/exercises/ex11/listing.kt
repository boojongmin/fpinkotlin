package chapter3.exercises.ex11

import chapter3.Cons
import chapter3.List
import chapter3.Nil
import chapter3.foldLeft
import chapter3.foldRight
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec
import utils.SOLUTION_HERE

// tag::init[]
fun <A> reverse(xs: List<A>): List<A> =
    foldLeft(xs, List.empty()) { a, b -> Cons(b, a) }
// foldRight(xs, List.empty()) { a, b -> Cons(a, b) }

// end::init[]

//TODO: Enable tests by removing `!` prefix
class Exercise11 : WordSpec({
    "list reverse" should {
        "reverse list elements" {
            reverse(List.of(1, 2, 3, 4, 5)) shouldBe
                List.of(5, 4, 3, 2, 1)
        }
    }
})
