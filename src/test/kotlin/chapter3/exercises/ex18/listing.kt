package chapter3.exercises.ex18

import chapter3.Cons
import chapter3.List
import chapter3.List.Companion.empty
import chapter3.Nil
import chapter3.foldLeft
import chapter3.foldRight
import chapter3.reverse
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec
import utils.SOLUTION_HERE

// tag::init[]
fun <A> filter(xs: List<A>, f: (A) -> Boolean): List<A> =
    reverse(foldLeft(xs, empty(), {ls, a -> if(f(a)){Cons(a, ls)} else {ls} } ))
    // foldRight(xs, empty(), {a, ls -> if(f(a)){Cons(a, ls)} else {ls} } )

// end::init[]

//TODO: Enable tests by removing `!` prefix
class Exercise18 : WordSpec({
    "list filter" should {
        "filter out elements not compliant to predicate" {
            val xs = List.of(1, 2, 3, 4, 5)
            filter(xs) { it % 2 == 0 } shouldBe List.of(2, 4)
        }
    }
})
