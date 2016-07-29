import org.scalatest.{Matchers, FunSuite}

/**
 * Created by glenn on 2016. 7. 29..
 */
//
class ClassSpec extends FunSuite with Matchers{
  //value == val 불변의 값, es6 const, c const
  test("class with val"){
    class ClassWithVal(val name: String)
    val classWithVal = new ClassWithVal("홍길동");
    classWithVal.name shouldBe "홍길동"
  }

  test("class with var"){
    class ClassWithVar(var name: String)
    val classWithVar = new ClassWithVar("홍길동");
    classWithVar.name = "김길동";
    classWithVar.name shouldBe "김길동"
  }
}


class Point(val x: Int, val y: Int) {
  override def toString(): String = "(" + x + ", " + y + ")"
}

object Classes1 extends App{
  println("hello world");

  val point = new Point(1, 2);
  println(point.x);
}


object  Classes2 {
  def main (args: Array[String]){
    val point = new Point(10, 20);
    println(point.x)
  }
}
