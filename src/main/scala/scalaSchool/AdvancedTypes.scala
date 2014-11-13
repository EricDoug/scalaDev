package scalaSchool

/**
 * @Author: EricDoug on 14-11-6.
 * @E-mail: liuxd6688@126.com
 *  A =:= B       A必须和B相等
 *  A <:< B       A必须是B的子类
 *  A <%< B       A必须可以被看做是B
 *
 */
class AdvancedTypes {

}
//使用<% 指定类型限制
class Container[A <% Int] {
  def addInt(x : A) = 123 + x
}

class Container1[A](value : A) {
  def addInt(implicit evidence : A =:= Int) = 123 + value
}

object AdvancedTypes {
  //隐函数允许类型自动转换
  implicit def strToint(x : String) = x.toInt
  implicit def floatToint(x : Float) = x.toInt



  def main(args : Array[String]) {
    val y : Int = "123"
    println(y)

    val res = math.max("123",111)
    println(res)

//    val res1 = new Container[String].addInt("123")
//    println(res1)
//    val res2 = new Container[Float].addInt(12.3)
//    println(res2)
      val res3 = new Container1(123).addInt
    println(res3)
//    val res4 = new Container1("123").addInt1
//    println(res4)

  }
}
