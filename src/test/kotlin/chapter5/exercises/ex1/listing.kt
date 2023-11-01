package chapter5.exercises.ex1

import chapter3.List
import chapter3.Nil
import chapter5.Cons
import chapter3.Cons as ConsL
import chapter5.Empty
import chapter5.Stream
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec
import utils.SOLUTION_HERE

//TODO: Enable tests by removing `!` prefix
class Exercise1 : WordSpec({
    //tag::init[]
    fun <A> Stream<A>.toList(): List<A> = when(this) {
        is Cons -> {
            ConsL(this.head(), this.tail().toList())
        }
        is Empty -> {
            Nil
        }
    }
    //end::init[]

    "Stream.toList" should {
        "force the stream into an evaluated list" {
            val s = Stream.of(1, 2, 3, 4, 5)
            s.toList() shouldBe List.of(1, 2, 3, 4, 5)
        }
    }
})
