package chapter6

/**
 * Created by EricDoug on 14-10-21.
 * 有理数(Rational number) ：n/d  n被称作分子(numerator)，d被称作分母(denominator)
 */
class Rational (n : Int,d : Int) {
  //precondition before create an object
  require( d != 0)
  //最大公约数
  private val g = gcd(n.abs,d.abs)
  val numer : Int = n / g
  val denom : Int = d / g
  //辅助构造器
  def this(n : Int) = this(n,1)
  //重写toString方法
  override def toString = numer + "/" + denom
  //加
  def +(that : Rational) : Rational = new Rational(numer * that.denom + that.numer * denom,denom * that.denom)
  //使用隐式转换
  def +(i : Int ) : Rational = new Rational(numer + i * denom,denom)
  //减
  def -(that : Rational) : Rational = new Rational(numer * that.denom - that.numer * denom,denom * that.denom)
  //implict transformation
  def -(i : Int) : Rational = new Rational(numer - i * denom,denom)

  //乘
  def *(that : Rational) : Rational = new Rational(numer * that.numer,denom * that.denom)
  //implict transformation
  def *(i : Int) : Rational = new Rational(numer * i,denom)
  //除
  def /(that : Rational) : Rational = new Rational(numer * that.denom,denom * that.numer)
  //implict division
  def /(i : Int) : Rational = new Rational(numer,denom * i)
  //判断大小
  def lessThan(that : Rational) = this.numer * that.denom < that.numer * this.denom
  //求最大
  def max(that : Rational) = if(this.lessThan(that)) that else this
  //隐式转换
  implicit def intToRational(x : Int) = new Rational(x)
  //greatest common divisor
  private def gcd(a : Int,b : Int) : Int = if(b == 0) a else gcd(b , a % b)
}

object Rational {
  def main(args : Array[String]) {
    val x = new Rational(2, 3)
    println(x * x)
  }
}
