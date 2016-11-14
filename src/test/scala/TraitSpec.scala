import org.scalatest.{Matchers, FunSuite}

/**
 * Created by glenn on 2016. 10. 10..
 */
class TraitSpec extends FunSuite with Matchers {

  test("trait") {
    //java interface
    trait Foo {
      def bar: String

      def toInt(int: Int): String
    }


    class FooImpl extends Foo {
      override def bar: String = "barbar"

      override def toInt(int: Int): String = int.toString
    }

    val foo = new FooImpl

    println(foo.bar)
    println(foo.toInt(10000))

    val foo2 = new Foo {
      override def bar: String = "barbarbar"

      override def toInt(int: Int): String = int.toString + "!!"
    }

    println(foo2.bar)
    println(foo2.toInt(10000))

    //두번째 특징 : 함수의 구현체를 가짐, class, abstract class
    trait Bar {
      def bar: String = "barbar"

      def toInt(int: Int): String
    }

    class BarImpl extends Bar {
      override def toInt(int: Int): String = int.toString
    }

    //자바는 다중상속이 되지않음

    //세번째 특징 : 변수를 가질수 있다
    trait Bar2 {
      val a = 10

      def bar: String = "barbar"

      def toInt(int: Int): String
    }

    //네번째 특징 : 기본 생성자가 없다

    //quiz!
    //2개의 trait를 만든다
    //2개의 A, B
    //A안에는 a라는 함수가 구현되어 있음
    //B안에는 a라는 함수가 구현되어 있음

    //AB... extends A with B
    //BA... extends B with A


    //우선순위가 뒤에 명시한 대상부터 찾는다
    trait A {
      println("hello A")

      def a: String = "A trait a"
    }

    trait B {
      println("hello B")

      def a: String
    }

    class C {
      println("hello C")

      def a  : String = "c"
    }

    class AB extends A with B {
      override def a: String = super.a
    }

    class BA extends B with A {
      override def a: String = "B trait a"
    }

    class ABC extends C with B with A {
      override def a: String = super.a
    }

    val ab = new AB
    println(ab.a)

    val ba = new BA
    println(ba.a)

    println((new ABC).a)

  }
}
