import org.scalatest.{Matchers, FunSuite}

/**
 * Created by glenn on 2016. 9. 28..
 */
class ImplicitSpec extends FunSuite with Matchers{
  //implicit 뜻 '은연중' <-> '명시적' explicit


  test("explicit") {
    import ImplicitTest.bar2


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
    implicit class Foo(b: String){
      def barbarbar: String = b + b + b
    }

    //몽키 패칭 => 안티패턴

    println(a4.barbarbar)
    println(new Foo(a4).barbarbar)
    //
  }

}



















