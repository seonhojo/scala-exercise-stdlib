import org.scalatest.{Matchers, FunSuite}

/**
 * Created by glenn on 2016. 9. 7..
 */
class CurrySpec extends FunSuite with Matchers{
  test("curry"){
    //def foo(a : Int ,b : Int, c : Int): Int = ??
    //입력이 1개고 출력이 1개인 함수를 만든다.



    def adder(x:Int, y:Int): Int = x + y

    val adder1 : (Int) => (Int) => Int = (adder _).curried

    val addWithOne = adder1(1)

    println(addWithOne(10))
    println(addWithOne(20))
  }

  test("syntax"){
    def adder(x: Int)(y:Int) : Int = x + y
    val adderWithOne: (Int) => Int = adder(1)

    println(adderWithOne(10))
    println(adderWithOne(20))
  }

  test("syntax2"){
    def adder(x: Int): Int => Int = (y: Int) => x + y
    val addWithOne: (Int) => (Int) = adder(1)

    println(addWithOne(10))
    println(addWithOne(20))
  }

  test("x + y + z"){
    def adder(x: Int): Int => Int = (y: Int) => x + y
    val addWithOne = adder(1)// x = 1
    val addWithOneAndTwo = addWithOne(2)// y = 1

    println(addWithOneAndTwo)//13
    //println(addWithOneAndTwo(20))//23
  }

  test("x + y + z = w, v1"){
    def adder(x: Int): Int => Int => Int = (y: Int) => (z: Int) => x + y + z
    val addWithOne = adder(1)// x = 1
    //val addWithOneAndTwo = addWithOne(2)// y = 1

    //println(addWithOneAndTwo(10))//13
    //println(addWithOneAndTwo(20))//23
  }

  test("x + y + z = w, v2"){
    def adder2(x: Int)(y: Int)(z: Int) = x + y + z
    //val addWithOne: (Int) => (Int) = adder(1)// x = 1
    //val addWithOneAndTwo = addWithOne(2)// y = 1

    //println(addWithOneAndTwo(10))//13
    //println(addWithOneAndTwo(20))//23
  }
}




