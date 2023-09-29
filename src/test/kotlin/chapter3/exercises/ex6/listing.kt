package chapter3.exercises.ex6

import chapter3.Cons
import chapter3.List
import chapter3.Nil
import chapter3.foldRight
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec


fun <A, B> foldRight(xs: List<A>, z: B, f: (a: A, b: B) -> B): B  = when(xs) {
    is Nil -> z
    is Cons -> f(xs.head, foldRight(xs.tail, z, f))

}
// tag::init[]
fun <A> product(xs: List<Double>) = foldRight(xs, 1.0) { a, b -> a * b }
fun <A> product2(xs: List<Double>): Double = foldRight(xs, 1.0) { a, b -> if( b == 0.0) {a} else {a*b} }

// end::init[]

//TODO: Enable tests by removing `!` prefix
class Exercise5 : WordSpec({

    "list product" should {
        "return all elements by product" { product<Double>(List.of(1.0, 2.0, 3.0, 4.0, 5.0)) shouldBe 120.0 }
        "return stoped product when meet 0.0" { product2<Double>(List.of(1.0, 2.0, 0.0, 3.0, 4.0)) shouldBe 2.0 }
    }
})
