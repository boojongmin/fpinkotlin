package chapter5.exercises.ex10

import chapter3.List
import chapter5.Stream
import chapter5.Stream.Companion.cons
import chapter5.toList
import chapter5.solutions.ex13.take
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec
import utils.SOLUTION_HERE

//TODO: Enable tests by removing `!` prefix
class Exercise10 : WordSpec({

    //tag::init[]
    fun fibs(): Stream<Int> {
        fun go(curr: Int, next: Int): Stream<Int> = cons({curr}, {go(next, curr + next )})

        return go(0, 1)
    }
    //end::init[]

    "fibs" should {
        "return a Stream of fibonacci sequence numbers" {
            fibs().take(10).toList() shouldBe
                List.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34)
        }
    }
})
