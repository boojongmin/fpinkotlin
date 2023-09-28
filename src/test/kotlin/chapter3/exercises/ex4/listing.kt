package chapter3.exercises.ex4

import chapter3.Cons
import chapter3.List
import chapter3.Nil
import chapter3.exercises.ex3.drop
import chapter7.sec1.l
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

// tag::init[]
fun <A> dropWhile(l: List<A>, f: (A) -> Boolean): List<A> = when(l) {
    is Nil -> l
    is Cons -> when(f(l.head)) {
        true -> {
            dropWhile(l.tail, f)
        }
        false -> l
    }
}




// end::init[]

//TODO: Enable tests by removing `!` prefix
class Exercise4 : WordSpec({

    "list dropWhile" should {
        "drop elements until predicate is no longer satisfied" {
            dropWhile(
                List.of(1, 2, 3, 4, 5)
            ) { it < 4 } shouldBe List.of(4, 5)
        }

        "drop no elements if predicate never satisfied" {
            dropWhile(
                List.of(1, 2, 3, 4, 5)
            ) { it == 100 } shouldBe List.of(1, 2, 3, 4, 5)
        }

        "drop all elements if predicate always satisfied" {
            dropWhile(
                List.of(1, 2, 3, 4, 5)
            ) { it < 100 } shouldBe List.of()
        }

        "return Nil if input is empty" {
            dropWhile(List.empty<Int>()) { it < 100 } shouldBe Nil
        }

        // 이건 아니다. 처음에 dropWhile이 false면 dropWhile은 동작을 멈춤.
        // "drop no elements if predicate equals one" {
        //     dropWhile(
        //         List.of(1, 2, 3, 4, 5)
        //     ) { it == 2 } shouldBe List.of(1, 3, 4, 5)
        // }
    }
})
