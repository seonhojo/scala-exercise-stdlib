import org.scalatest.{Matchers, FunSuite}
import org.scalatest.matchers.Matcher

/**
 * Created by glenn on 2016. 8. 1..
 */
class OptionalSpec extends FunSuite with Matchers{
  //Option = Some or None
  test("option"){
    val someValue : Option[String] = Some("Hello Option");
    someValue shouldBe Some("Hello Option");

    val someValue2 : Option[String] = None;
    someValue2 shouldBe None;
  }


  def maybeItWillReturnSomething(flag: Boolean): Option[String] = {
    if (flag) Some("Found value") else None
  }

  val value1 = maybeItWillReturnSomething(true)
  val value2 = maybeItWillReturnSomething(false)

  //Option값이 None일경 값을 대체
  test("getOrElse"){
    value1 getOrElse "No value" shouldBe "Found value"
    value2 getOrElse "No value" shouldBe "No value"
    value2 getOrElse {
      "default function"
    } shouldBe "default function"
  }


  test("empty") {
    val emptyValue1 = maybeItWillReturnSomething(true)
    val emptyValue2 = maybeItWillReturnSomething(false)

    emptyValue1.isEmpty shouldBe false
    emptyValue2.isEmpty shouldBe true
  }

  //match
  test("match"){
    val someValue: Option[Double] = Some(20.0)
    val matchValue = someValue match {
      case Some(v) ⇒ v
      case None ⇒ 0.0
    }
    matchValue shouldBe(20.0)

    val noValue: Option[Double] = None
    val matchValue2 = noValue match {
      case Some(v) ⇒ v
      case None ⇒ 0.0
    }
    matchValue2 shouldBe(0.0)

  }


  //map
  test("map"){
    val number: Option[Int] = Some(3)
    val noNumber: Option[Int] = None
    val result1 = number.map(_ * 1.5)
    val result2 = noNumber.map(_ * 1.5)

    result1 shouldBe Some(4.5)
    result2 shouldBe None
  }

  test("folder"){
    val number: Option[Int] = Some(3)
    val noNumber: Option[Int] = None
    val result1 = number.fold(0)(_ * 3)
    val result2 = noNumber.fold(0)(_ * 3)

    result1 shouldBe 9
    result2 shouldBe 0
  }
}
