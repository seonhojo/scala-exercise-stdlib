import org.scalatest.{FunSuite, Matchers}

/**
  * Created by glenn on 2016. 8. 17..
  */
class SetSpec extends FunSuite with Matchers{

   test("Set") {
     val list = List(1, 1, 1, 1, 1, 1)
     val set1 = Set(1, 1, 1, 1, 1, 1)

     println(list)
     println(set1)

     val set2 = set1 + 2
     println(set2)

     val set3 = Set(2, 3, 4, 5)
     val set4 = set2 ++ set3
     println(set4)

     //집합
     //교집합, 차집합, 합집합
     println(set4.intersect(set2)) //교집합
     val set5 = Set(2, 3, 4, 5)
     println(set5.union(set2)) //합집합
     println(set5.diff(set2)) //차집합
     println(set2.diff(set5)) //차집합
   }
 }
