package programminginscala.chapter9

import java.io.{File, PrintWriter}

/**
 * Created by EricDoug on 14-10-24.
 */
class ControlObject {

}

object ControlObject {

  def apply() = new ControlObject()

  private def filesHere = (new java.io.File("./src/main/scala/programminginscala/chapter5/")).listFiles()

  def filesEnding(query : String) = for(file <- filesHere;if file.getName.endsWith(query)) yield file

  def filesContaining(query : String) = for(file <- filesHere;if file.getName.contains(query)) yield file

  def filesMatching(query : String,matcher : (String,String) => Boolean) = {
    for(file <- filesHere;if matcher(file.getName,query)) yield file
  }

  def filesEnding2(query : String) = filesMatching(query, _.endsWith(_))

  def filesContaining2(query: String ) = filesMatching(query,_.contains(_))

  def filesRegex2(query : String) = filesMatching(query,_.matches(_))

  private def filesMatching2(matcher : String => Boolean) = for(file <- filesHere;if matcher(file.getName)) yield file

  def filesEnding3(query : String) = filesMatching2( _.endsWith(query))

  def filesContaining3(query : String) = filesMatching2(_.contains(query))

  def filesRegex3(query : String) = filesMatching2(_.matches(query))

  //currying
  def curriedSum(x : Int)(y : Int) = x + y

  def first(x : Int) = (y : Int) => x + y

  def twice(op : Double => Double,x : Double) = op(op(x))

  //编写新的控制结构
  def withPrintWriter(file:File)(op : PrintWriter => Unit ){
    val writer = new PrintWriter(file)
    try{
      op(writer)
    }finally {
      writer.close()
    }
  }

//  val files = ControlObject.filesEnding(".scala")
//
//  files.foreach(println)
  def main(args : Array[String]) {
    val files = ControlObject.filesEnding2(".scala")

    files.foreach(println)

  // println(curriedSum(1)(2))
//  val second = first(1)
//  println(second(2))
//  val onePlus = curriedSum(1)_
//  println(onePlus)
//  println(onePlus(2))
  val res = twice(_ + 1,5)
  println(res)

  val file = new File("./build.sbt")
  withPrintWriter(file){
    writer => writer.println(new java.util.Date)
  }
}
}
