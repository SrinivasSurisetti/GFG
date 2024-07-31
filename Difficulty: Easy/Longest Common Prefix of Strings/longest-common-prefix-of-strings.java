//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String longestCommonPrefix(String arr[]) {
        // code here
        if(arr.length ==0 || arr == null){
            return "-1";
        }
        String min = arr[0];
        for(int i= 1;i<arr.length;i++){
            if(arr[i].length()<min.length()){
                min = arr[i];
            }
        }
        int minlength = min.length();
        for(int i =  0;i<minlength;i++){
            char ch = min.charAt(i);
            for(int j = 0;j<arr.length;j++){
                if(ch != arr[j].charAt(i)){
                    return i==0 ? "-1" : min.substring(0,i);
                }
            }
        }
        return minlength == 0 ? "-1" : min;
    }
}