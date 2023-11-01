package chapter5.exercises.ex16

import chapter3.List
import chapter5.Stream
import chapter5.toList
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec
import utils.SOLUTION_HERE

//TODO: Enable tests by removing `!` prefix
class Exercise16 : WordSpec({

    //tag::scanright[]
    fun <A, B> Stream<A>.scanRight(z: B, f: (A, () -> B) -> B): Stream<B> =
        foldRight({ z to Stream.of(z) },
            { a: A, p0: () -> Pair<B, Stream<B>> ->
                val p1: Pair<B, Stream<B>> by lazy { p0() }
                val b2: B = f(a) { p1.first }
                Pair<B, Stream<B>>(b2, Stream.cons({ b2 }, { p1.second }))
            }).second
    //end::scanright[]

    "Stream.scanRight" should {
        "behave like foldRight" {
            Stream.of(1, 2, 3)
                .scanRight(0, { a, b ->
                    a + b()
                }).toList() shouldBe List.of(6, 5, 3, 0)
        }
    }
})
