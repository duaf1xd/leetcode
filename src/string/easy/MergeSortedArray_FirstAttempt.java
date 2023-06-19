package string.easy;

import java.util.Arrays;

public class MergeSortedArray_FirstAttempt {

    //This was not accepted by Leetcode because apparently reassigning nums1 to a new array isn't accepted
    //Frankly this is also a mess to understand
    //Solution
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] result= new int[m+n];

        int processedNumbers = 0;
        int processedRight = 0;

        for(int i=0; processedNumbers< m+n; ++i){
            if(i>=m){
                result[processedNumbers] = nums2[processedRight];
                ++processedRight;
                ++processedNumbers;
                continue;
            }

            int leftValue = nums1[i];

            if(processedRight >= n){
                result[processedNumbers] = leftValue;
                ++processedNumbers;
                continue;
            }

            for(int j=processedRight; j< n; ++j){
                int rightValue = nums2[j];

                if(leftValue <= rightValue){
                    result[processedNumbers] = leftValue;
                    ++processedNumbers;
                    break;
                }
                else {
                    result[processedNumbers] = rightValue;
                    ++processedRight;
                    ++processedNumbers;
                }
            }
        }

        nums1 = result;

        System.out.println(Arrays.toString(nums1));
    }

    //Test
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;

//        int[] nums1 = {0};
//        int[] nums2 = {1};
//        int m = 0;
//        int n = 1;

//        int[] nums1 = {1};
//        int[] nums2 = {};
//        int m = 1;
//        int n = 0;

        merge(nums1, m, nums2, n);
    }
}
