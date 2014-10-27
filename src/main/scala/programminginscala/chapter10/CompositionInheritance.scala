package programminginscala.chapter10

/**
 * Created by EricDoug on 14-10-27.
 */
class CompositionInheritance {

}
//抽象类：抽象类不能实例化
abstract class Element {
    def contents : Array[String]

//  def height : Int = contents.length
//    val height = contents.length
//  def width : Int = if(height == 0) 0 else contents(0).length
//    val width = if(height == 0) 0 else contents(0).length
  def width : Int = if(height == 0) 0 else contents(0).length

  def height : Int = contents.length
  import Element.elem

  def above(that : Element) : Element = elem(this.contents ++ that.contents)

  def beside(that : Element) : Element = elem(for((line1,line2) <- this.contents zip that.contents) yield line1 + line2)

  override def toString = contents.mkString("\n")

  def demo() {
    println("Element's implementation invoked")
  }


}
//参数化字段
class ArrayElement(val contents : Array[String]) extends Element {
//  def contents : Array[String] = conts
  /*
    scala里的字段和方法属于相同的命名空间。这让字段可以重写无参数的方法
   */
//  val contents : Array[String] = conts
  override def demo() {
  println("ArrayElement's implementation invoked")
}

}
//参数修饰符
class Cat {
  val dangerous = false
}

class Tiger(override val dangerous : Boolean,private var age : Int) extends Cat

class LineElement(s : String) extends ArrayElement(Array(s)) {
  override def width = s.length
  override def height = 1
  override def demo() {
    println("LineElement's implementation invoked")
  }
}

//polymorphism
class UniformElement(ch : Char,override val width : Int,override val height : Int) extends Element {
  private val line =  ch.toString * width
//  def contents = Array.make(height,line)
  def invokeDemo(e : Element) {
  e.demo()
}
}
object Element {
  def elem(contents : Array[String]) : Element = new ArrayElement(contents)

  def elem(chr : Char,width : Int,height : Int) : Element = new UniformElement(chr,width,height)

  def elem(line : String) : Element = new LineElement(line)

  private class ArrayElement(val contents : Array[String]) extends Element

  private class LineElement(s : String) extends Element{
    val contents = Array(s)
    override def width = s.length
    override def height = 1
  }

  private class UniformElement(ch : Char,override val width : Int,override val height : Int) extends Element {
    private val line = ch.toString * width
//    def contents = Array.(height,line)
  }
}

object CompositionInheritance {
  def apply() = new CompositionInheritance

  def main(args : Array[String]) {
    val ae = new ArrayElement(Array("hello","world"))
    println(ae.width)
  }

}