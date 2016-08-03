import org.scalatest.{Matchers, FunSuite}

/**
 * Created by glenn on 2016. 8. 3..
 */
class LamdaSpec extends FunSuite with Matchers{
  test("lamda"){
    // method, function

    var f:(Int) => String = (x: Int) => x.toString
    val f2 = new Function[Int, String]{
      override def apply(v1: Int) : String = v1.toString
    }

    val f3 = new Function[Int, String]{
      override def apply(v1: Int) : String = v1.toString
    }

    def f4(a: Int) : String = a.toString

    f2(10) shouldBe "10"
    f3(100) shouldBe "100"
    f4(1000) shouldBe "1000"


    //def
    //val

    def x = 10+1  //호출할때마다 연산
    val y = 10+1  //연산후 결과값을 저장
  }

}
