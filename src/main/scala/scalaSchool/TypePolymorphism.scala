package scalaSchool

/**
 * @Author: EricDoug on 14-11-6.
 * @E-mail: liuxd6688@126.com
 *
 *
 */
class TypePolymorphism {
  /*
    scala的类型系统必须同时解释类层次和多态性。
    如果T'是T一个子类，Container[T']应该被看做是Container[T]的子类？
    变性(Variance)注解允许你表达类层次结构和多态类型之间的关系
    协变(covariant)       C[T']是C[T]的子类   [+T]
    逆变(contravariant)   C[T]是C[T']的子类   [-T]
    不变(invariant)       C[T]和C[T']无关     [T]
   */
  def varianceTest() = {

  }
}


class Animal {
  val sound = "rustle"
}

class Bird extends Animal {
  override val sound = "call"
}

class Chicken extends Bird {
  override val sound = "cluck"
}

object TypePolymorphism extends App {
  val getTweet: (Bird => String) = ((a: Animal) => a.sound)
  println(getTweet)

  //边界
  //def cacophony[T](things : Seq[T]) = things map (_.sound)
  def biophony[T <: Animal](things: Seq[T]) = things map (_.sound)

  //量化
  def count(l : List[_]) = l.size
  def count1(l : List[T forSome {type T}]) = l.size

  def hashcodes(l : Seq[_ <: AnyRef]) = l map (_.hashCode())


  val res = biophony(Seq(new Chicken, new Bird))
  println(res)

  val flock = List(new Bird,new Bird)

  val res1 = new Chicken :: flock
  println(res1)
  val res2 = new Animal :: flock
  println(res2)
  //val res3 = hashcodes(Seq(1,2,3))
  //println(res3)
  val res4 = hashcodes(Seq("one","two","three"))
  println(res4)
}