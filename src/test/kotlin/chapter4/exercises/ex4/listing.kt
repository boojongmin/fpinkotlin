package chapter4.exercises.ex4

import chapter3.Cons
import chapter3.List
import chapter3.Nil
import chapter4.None
import chapter4.Option
import chapter4.Some
import chapter4.foldRight
import chapter4.fx
import chapter4.map
import chapter4.solutions.ex3.map2
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec
import utils.SOLUTION_HERE

//tag::init[]
fun <A> sequence(xs: List<Option<A>>): Option<List<A>> =
    xs.foldRight(Some(Nil)) { oi1: Option<A>, oi2: Option<List<A>> ->
        map2(oi1, oi2) { i1: A, i2: List<A> -> Cons(i1, i2)}
    }



//end::init[]

//TODO: Enable tests by removing `!` prefix
class Exercise4 : WordSpec({

    "sequence" should {
        "turn a list of some options into an option of list" {
            val lo =
                List.of(Some(10), Some(20), Some(30))
            sequence(lo) shouldBe Some(List.of(10, 20, 30))
        }
        "turn a list of options containing none into a none" {
            val lo =
                List.of(Some(10), None, Some(30))
            sequence(lo) shouldBe None
        }
    }
})
