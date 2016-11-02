import org.scalatest.{FunSuite, Matchers}

import scala.concurrent.Future

/**
 * Created by glenn on 2016. 9. 28..
 */
class ImplicitSpec extends FunSuite with Matchers {
  //implicit 뜻 '은연중' <-> '명시적' explicit
  //기존의 스칼라 라이브러리들이 많이 사용하고 있으며
  //라이브러리를 사용할때 잘이용할수 있다.



  test("explicit") {
    def foo(bar: String): String = bar + "" + bar
    val str = "hello"
    implicit val str2 = "world"
    //implicit val str3 = "world1111"

    foo(str) // -> 명시적

    println(foo(str))

    def foo1(implicit bar2: String): String = bar2 + "" + bar2

    println(foo1(str))
    println(foo1)

    //1.로컬 스코프
    //2.컴패니언 오브젝트
    //3.import 대상을 찾음
    //찾는 기준은 type

    //Quiz. 만약에 str도 implicit 붙인다면 compile이 될것인가?


    //1.함수의 파라미터의 implicit
    //2.변수의 implicit

    // 1. implicit val a 변수,
    // 2. def foo(implicit var: String): String =??? 함수의 인자,
    // 3. implicit def foo(a: String): Int 함수,
    // 4. implicit class Foo(a: String){
    //      def var: String = a + " " + a
    //    }

    case class Status(status: Int)

    //implicit def foo2(bar: Int): String = bar.toString + " 10000"
    implicit def foo2(bar: Int): Status = Status(bar)

    //암묵적인 타입 캐스팅

    //val a1: String = 123
    //val a2: String = foo2(123)
    val a3: Status = foo2(123)
    val a4: String = "123"

    //println(a1)
    //println(a2)
    println(a3)


    //문법요소
    implicit class Foo(b: String) {
      def barbarbar: String = b + b + b
    }

    //몽키 패칭 => 안티패턴

    println(a4.barbarbar)
    println(new Foo(a4).barbarbar)


    //implicit part 2
    //class의 생성자 --> 안됨
    /*case class Bar(a: String)
    case class Cheese(c: Int, b: Bar)

    implicit class Foo2(c: Cheese)(implicit bar : Bar){
      def barbar(): String ={
        c.copy(b = bar).b.a
      }
    }

    val cheese = Cheese(10, Bar("cheese"))
    cheese.barbar()*/




    test("실전") {
      //1.암묵적인 type casting

      //Edina(sul: String) ==> Suldina(edina: String)
      case class Edina(sul: String)
      case class Suldina(edina: String)


      /*
      case class Status(status: Int)
      //implicit def foo2(bar: Int): String = bar.toString + " 10000"
      implicit def foo2(bar: Int): Status = Status(bar)
      */

      //implicit class TypeCasting(sul: String): Suldina = Suldina(sul)
      //implicit class TypeCasting(sul: String)
      implicit def casting(edina: Edina): Suldina = Suldina(edina.sul)
      val suldina: Suldina = Edina("isool")
      println(suldina)

      //2.기존에 있는 class 에 문법 추가하기
      //Edina에 name이라는 함수를 추가해봅시다.

      //시도
      //implicit class EdinaName(sul: String, name: String): Edina

      //클래스의 생성자가 중요
      //정답
      implicit class EdinaName(e: Edina) {
        def name = "에디나"
      }

      val e1 = Edina("막걸리")
      e1.name == "에디나"


      //3. 암무적인 변수가 있음
      //암묵적인 변수를 특정 클래스에 주입
      //val ec = scala.concurrent.ExecutionContext.Implicits.global
      implicit val ec = scala.concurrent.ExecutionContext.Implicits.global
      /*Future{
        println(10)
        Thread.sleep(1000)
        1+1
      }(ec)*/
      val a = Future[Int](2)(ec)
      val list = List[Int](2)
      val future = Future[Int](2)
      val set = Set[Int](2)


    }
  }
}

