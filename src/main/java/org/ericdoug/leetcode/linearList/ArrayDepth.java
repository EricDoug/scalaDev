package org.ericdoug.leetcode.linearList;

/**
 * Created by playcrab on 14-11-5.
 */
public class ArrayDepth {
    /*
       1.Remove Duplicates from Sorted Array
       ps:Given a sorted array,remove the duplications in place such that each element appear only once and return the new length
     */
    public int removeDuplicates_from_sortedArray(int A[]){
        if(A.length == 0) return 0;
        if(A.length == 1) return 1;
        int index = 0;
        for(int i = 1;i < A.length;i++){
            if(A[index] != A[i]){
                A[++index] = A[i];
            }
        }
        return  index + 1;
    }
    /*
       2.Remove Duplicates from Sorted Array Ⅱ
        The duplicates are allowed at most twice
     */
    public int removeDuplicates_from_sortedArray2(int A[]){
        if(A.length <= 2) return A.length;
        int index = 2;
        for(int i=2;i< A.length;i++){
            if(A[i] != A[index-2]){
                A[index++] = A[i];
            }
        }
        return index;
    }
    /* Search in Rotated Sorted Array
       Suppose a sorted array is rotated at some pivot unknown to you beforehand.
     */
    public int searchInRotatedSortedArray1(int A[],int target){
        if(A.length == 0) return -1;
        if(A.length == 1) {
            if(A[0] == target)
                return 0;
            else
                return -1;
        }
        int left = 0;
        int right = A.length ;
        while(left != right){
            int mid = (left + right)/2;
            if(A[mid] == target){
                return mid;
            }
            if (A[left] <= A[mid]){
                if(A[left] <= target && target < A[mid])
                    right = mid;
                else
                    left = mid + 1;
            }
            else{
                if(A[mid] >= target && target < A[right])
                    left = mid +1;
                else
                    right = mid;
            }
        }

        return -1;
    }
    /*
        What if duplicates in the rotated sorted array?

     */
    public int searchInRotatedSortedArray2(int A[],int target){
        if(A.length == 0) return -1;
        if(A.length == 1) {
            if(A[0] == target)
                return 0;
            else
                return -1;
        }
        int left = 0;
        int right = A.length;
        int mid = 0;
        while(left != right){
            mid = (left+right) / 2;
            if(A[mid] == target){
                return mid;
            }

            if(A[left] < A[mid]){
                if(A[left] <= target && target < A[mid]){
                    right = mid;
                }
                else
                    left = mid + 1;
            }
            else if(A[left] > A[mid]){
                if(A[mid] <= target && target < A[left])
                    left = mid + 1;
                else
                    right = mid;
            }
            else{
                left++;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        //新建一个实例
        ArrayDepth arrayDepth = new ArrayDepth();
        //remove duplicates from sorted array
        int[] arr1 = {1,1,2};
        System.out.print("Before handle with remove duplicates:");
        for(int x : arr1){
            System.out.print(x);
        }
        System.out.println();

        int arrLength = arrayDepth.removeDuplicates_from_sortedArray(arr1);
        System.out.print("The length of the handled array:" + arrLength + "," + "the array is:");
        for(int x=0;x<arrLength;x++){
            System.out.print(arr1[x]);
        }
        System.out.println();

        //test remove duplicates from sorted array2
        int[] arr2 = {1,1,1,2,2,3};
        System.out.print("Before handle with remove duplicates2:");
        for(int x : arr2){
            System.out.print(x+" ");
        }
        System.out.println();

        int arrLength2 = arrayDepth.removeDuplicates_from_sortedArray2(arr2);
        System.out.print("The length of the handled array2:" + arrLength + "," + "the array is:");
        for(int x=0;x<arrLength2;x++){
            System.out.print(arr2[x]+" ");
        }
        System.out.println();


    }
}
