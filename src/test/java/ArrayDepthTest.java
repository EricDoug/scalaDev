/**
 * @Author: EricDoug on 14-11-6.
 * @E-mail: liuxd6688@126.com
 */
import org.ericdoug.linearList.ArrayDepth;

public class ArrayDepthTest {
    public static void main(String args[]){
        //test the rotated sorted array1
        ArrayDepth arrayDepth = new ArrayDepth();
        int arr1[] = {0,1,2,3,4,5,6,7};
        int target1 =1;
        int res1 = arrayDepth.searchInRotatedSortedArray1(arr1, target1);
        System.out.println("the target " + target1 + " is in the " + res1 + " place!");
        //test to the rotated sorted array2
        int arr2[] = {1,3,1,1};
        int target2 = 3;
        int res2 = arrayDepth.searchInRotatedSortedArray2(arr2,target2);
        System.out.println("the target "+target2+" is in the "+res2+" place!");

    }
}
