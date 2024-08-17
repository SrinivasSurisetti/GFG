//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
    public static long[] productExceptSelf(int nums[]) {
        // code here
        long[] ar = new long[nums.length];
        long product=1;
        for(int val : nums){
            product*=val;
        }
        for(int i = 0;i<ar.length;i++) {
            if(nums[i]!=0){
                ar[i]=product/nums[i];
            }
            else{ //if val = 0
                ar[i] = 1;
                for(int j = 0;j<nums.length;j++){
                    if(i!=j){
                        ar[i]*=nums[j];
                    }
                }
            }
        }
        return ar;
    }
}
