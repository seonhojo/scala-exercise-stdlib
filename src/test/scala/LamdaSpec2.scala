import org.scalatest.{Matchers, FunSuite}

/**
 * Created by glenn on 2016. 8. 8..
 */
class LamdaSpec2 extends FunSuite with Matchers{
  // int => string 인자로 받는다.
  //int * 10 하고 문자열로 변환

  def firstHighOrderFunc(value : Int)(f : Int => String): String = {
    f(value)
  }

  firstHighOrderFunc(10)(x => x.toString)

  // 1.고계함수, 고차함수 API를 활용
  // map, fold, reduce, flatMap
  val list = List(1, 2, 3)

  //1. 맵을 이용해서 각각 +10을 해보자
  println(list.map(f => f + 10))
  list.map(f => f + 10)
  list.map(_ + 10)
  def plus10(i : Int) = i + 10
  list.map(plus10)

  //2. reduce를 이용해서 전체의 합
  //1, 2, 3
  //(x, y) ==> (1, 2) => 1 + 2
  //(3, 3) => 3 + 3 => 6
  //왼쪽은 현재의 합, 오른쪽은 다음 값
  list.reduce((x, y) => x + y)//순차적으로 돈다.
  list.reduce(_ + _)
  list.sum

  //3. fold를 이용해서 전체곱을 구하세요
  //(1, 1) => 1 * 2
  //(1, 2) => 2
  //(2, 3) => 6
  list.foldLeft(0)((x, y) => x * y)
  list.foldLeft(0)(_ * _)

  //4. flatMap을 이용해서 List(11, 12, 22, 23, 33, 34)를 만드시오
  //꽃, 함수형 언어에서의 꽃
  //map + flatten
  list.flatMap{ i => List(i * 11, i * 11 + 1)}
  list.flatMap( i => List(i * 11, i * 11 + 1))
  list.map( i => List(i * 11, i * 11 + 1))
}
