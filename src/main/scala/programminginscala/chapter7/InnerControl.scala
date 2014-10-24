package chapter7

/**
 * Created by EricDoug on 14-10-23.
 */
class InnerControl {
  val filesHere = (new java.io.File(".")).listFiles

  def fileLines(file : java.io.File) = scala.io.Source.fromFile(file).getLines.toList

  def grep(pattern : String) = {
    for {
      file <- filesHere
      if file.getName.endsWith(".scala")
      line <- fileLines(file)
      if line.trim.matches(pattern)
    }  println(file + ":" + line.trim)
  }

  def scalaFiles = for {
    file <-filesHere
    if file.getName.endsWith(".scala")
  } yield file

  val forLineLengths = for {
    file <- filesHere
    if file.getName.endsWith(".scala")
    line <- fileLines(file)
    trimmed = line.trim
    if trimmed.matches(".*for.*")
  } yield  trimmed.length
  //example for throw exception
  def enenTest(n : Int) = {
    val half = if (n % 2 == 0) n / 2 else throw new RuntimeException("n must be even")
  }

  def matchTest(args : Array[String]) = {
    val firstArg = if(args.length > 0) args(0) else ""
    firstArg match {
      case "salt" => println("pepper")
      case "chips" => println("salsa")
      case "eggs" => println("bacon")
      case _ => println("huh?")
    }
   //递归式替换循环
  def searchFrom(i : Int):Int = {
    if(i >= args.length) -1
    else if (args(i).startsWith("-")) searchFrom(i + 1)
    else if (args(i).endsWith(".scala")) i
    else searchFrom(i + 1)
    }
  }

  def printMultiTable() {
    var i = 1
    while(i <= 10) {
      var j = 1
      while (j <= 10) {
        val prod = (i * j).toString
        var k = prod.length
        while (k < 4) {
          print(" ")
          k += 1
        }
        print(prod)
        j += 1
      }
      println()
      i += 1
    }

  }

  //使用函数式风格重新以上功能
  def makeRowSeq(row : Int) = {
    for (col <- 1 to 10) yield {
      val prod = (row * col).toString
      val padding = " " * (4 - prod.length)
      padding + prod
    }
  }

  def makeRow(row : Int) = makeRowSeq(row).mkString

  def printMultiTable1( ) = {
    val tableSeq =
    for (row <- 1 to 10)
      yield makeRow(row)
    tableSeq.mkString("\n")
  }
}

object InnerControl {
  def main(args : Array[String]){
    val innerControl = new InnerControl
    val result = innerControl.printMultiTable1()
    println(result)

  }
}
