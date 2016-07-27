/**
 * Created by glenn on 2016. 7. 27..
 */

import org.scalatest.{Matchers, FunSuite}

class AssertSpec extends FunSuite with Matchers{
  test("hello scala"){
    println("world")
  }

  test("assert"){
    val left = 2
    val right = 1
    assert(left != right)
  }

  test("true"){
    true shouldBe true
  }

  test("equality"){
    val v1 = 4
    v1 shouldEqual(4)
  }

  test("values"){
    assert(2 == 1+1)
  }

}
