package leetcode

/**
 * Created by playcrab on 14-10-27.
 */
class LinearList {


}


object LinearList {
  def apply() = new LinearList

  def removeDuplicatesFromSortedArray(arr : Array[Int]) : Int = {
    if(arr.length == 0) return 0
    if(arr.length == 1) return 1
    if(arr.length == 2) {
      if (arr(0) == arr(1))
        return 1
      else return 2
    }

     var p = 0;
     var q = 1;

//    while(q < arr.length && p < arr.length){
//      if(arr[q] == arr[p])
//        q += 1;
//      else
//        arr[++p] = arr[q]
//    }
//
    return p + 1
  }

  def main(args : Array[String]) {

  }
}