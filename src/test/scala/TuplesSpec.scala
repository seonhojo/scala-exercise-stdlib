import org.scalatest.{Matchers, FunSuite}

/**
 * Created by glenn on 2016. 8. 3..
 */
class TuplesSpec extends FunSuite with Matchers{
  test("tuple"){
    //alt + enter
    val t: (Int, String, Console.type, Long, Float) = (1, "hello", Console, 1L, 2F)

    //t._1 shouldBe t._5
    val (a, b, c, d, e) = t
    println(a)
    println(b)
  }

  test("tuple2"){
    val student = ("Sean Rogers", 21, 3.5)
    val (name, age, gpa) = student

    name shouldBe "Sean Rogers"
    age shouldBe 21
    gpa shouldBe 3.5
  }

}
