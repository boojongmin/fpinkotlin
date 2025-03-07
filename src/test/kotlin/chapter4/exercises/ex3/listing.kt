package chapter4.exercises.ex3

import chapter4.None
import chapter4.Option
import chapter4.Some
import chapter4.exercises.ex1.flatMap
import chapter4.exercises.ex1.orElse
import chapter4.sec3.lift
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec
import utils.SOLUTION_HERE

//tag::init[]
fun <A, B, C> map2(oa: Option<A>, ob: Option<B>, f: (A, B) -> C): Option<C> =
    oa.flatMap { a: A->
            ob.map {  b: B ->
                f(a, b)
            }
    }
//end::init[]

//TODO: Enable tests by removing `!` prefix
class Exercise3 : WordSpec({

    "map2" should {

        val a = Some(5)
        val b = Some(20)
        val none = Option.empty<Int>()

        "combine two option values using a binary function" {
            map2(a, b) { aa, bb ->
                aa * bb
            } shouldBe Some(100)
        }

        "return none if either option is not defined" {
            map2(a, none) { aa, bb ->
                aa * bb
            } shouldBe None

            map2(none, b) { aa, bb ->
                aa * bb
            } shouldBe None
        }
    }
})
