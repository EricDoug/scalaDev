package org.ericdoug.linearList;

/**
 * Created by playcrab on 14-11-5.
 */
public class ArrayDepth {
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
}
