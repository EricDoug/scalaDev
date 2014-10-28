package programminginscala.chapter11

/**
 * Created by playcrab on 14-10-28.
 */
class Hierarchy {

}

object Hierarchy {
  def divide(x : Int,y : Int) : Int = {
    if(y != 0) x / y
      else error("can't divide by zero")
  }
  def main(args : Array[String]) {

  }
}