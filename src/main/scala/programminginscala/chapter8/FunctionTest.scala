package programminginscala.chapter8

/**
 * Created by EricDoug on 14-10-24.
 * 1.读取指定文件名的文件，并打印输出所有长度超过设定宽度的文本行，每个打印输出的文本行前缀所在文件的文件名
 */
class FunctionTest {


}

object FunctionTest {
  //单例生成类实例
  def apply() = new FunctionTest()

  def processFile(filename : String,width : Int) {

    def processLine( filename: String, width : Int, line: String) = {
          if(line.length > width)
            println(filename + " : " + line.trim)
        }

    import scala.io.Source

    val source = Source.fromFile(filename)
    for (line <- source.getLines)
      processLine(filename, width, line)
  }

//  private def processLine( filename: String, width : Int, line: String) = {
//    if(line.length > width)
//      println(filename + " : " + line.trim)
//  }
  def sum(a : Int,b : Int,c : Int) : Int = a + b + c

  //closure
  def closureTest : Int = {
    val someNumbers = List(-11,-10,-5,0,5,10)

    var sum = 0

    someNumbers.foreach(sum += _)

    sum
  }
  //重复参数
  def echo(args : String*) = for(arg <- args) println(arg)

  def makeIncreaser(more : Int) = (x : Int) => x + more

  //递归
  def boom(x : Int) : Int = if(x == 0) throw new Exception("boom!") else boom(x - 1 ) + 1
  //尾递归
  def bang(x : Int) : Int = if(x == 0) throw new Exception("bang!") else bang(x - 1)

  def main(args : Array[String]){
    //FunctionTest.processFile("build.sbt",10)
//    val width = args(0).toInt
//    for(arg <- args.drop(1))
//      FunctionTest.processFile(arg,width)
    //val someNumbers = List(-11,-10,-5,0,56,10)

    //someNumbers.foreach((x : Int) => println(x))
    //去除参数类型
//    someNumbers.foreach(x => println(x))
    //占位符语法
   // someNumbers.filter(_ > 0).foreach(x => println(x))
//    val f = (_ : Int) + (_ : Int)
//    println(f(5,10))
    //部分应用函数  partially applied function
    //someNumbers.foreach(println _)
    //someNumbers.foreach(println)
   // println(sum(1,2,3))
//    val a = sum _
//    println(a(1,2,3))
//    val b = sum(1,_ : Int,3)
//    println(b(2))
//    println(b(5))
    //println(FunctionTest.closureTest)
//    val inc1 = FunctionTest.makeIncreaser(1)
//    val inc9999 = FunctionTest.makeIncreaser(9999)

//    println(inc1(10))
    //FunctionTest.echo("hello","World")
//    val arr = Array("What's","up","doc?'")
//    FunctionTest.echo(arr : _*)
    //FunctionTest.boom(5)
    //FunctionTest.bang(5)
 }

}
