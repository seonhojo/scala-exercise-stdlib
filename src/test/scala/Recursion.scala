import org.scalatest.{Matchers, FunSuite}

import scala.annotation.tailrec

/**
 * Created by glenn on 2016. 9. 19..
 */
class Recursion extends FunSuite with Matchers{

  //피보나치 수열


  /*def fib(n: Int): Int = {
    @annotation.tailrec
    def loop(n: Int, prev: Int, cur: Int): Int =
      if (n <= ?) prev
      else loop(n - ?, cur, prev + cur)
    loop(n, 0, 1)
  }
  fib(5) should be(5)
  */

  //팩토리얼
  // n! => 1 * 2 * 3 .... n - 1 * n
  // (n + 1)! = n! * (n + 1)
  def factorial(n : Int): Int = {
    //1. 기본값에 구현
    if( n == 0){
      1
    }

      //반복 부분에 대한 구현
    else {
      factorial(n - 1) * n
    }
  }

  //팩토리얼
  def factorialTailrec(n : Int): Int = {

    @tailrec
    def fact(n1: Int, acc: Int) : Int ={
      //1. 기본값에 구현
      if( n1 == 0){
        acc
      }
      else{
        fact(n1 - 1, acc * n1)
      }
    }

    fact(n, 1)
  }

  test("factorial"){
    factorial(2) shouldBe 2

    println(factorial(4).toString)
    println(factorialTailrec(4).toString)
  }
}
