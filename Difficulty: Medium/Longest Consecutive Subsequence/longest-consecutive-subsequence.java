//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read first array
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            int res = ob.longestConsecutive(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
        int curNum = 0;
        int curMax = 0;
        int max = 0;
        if(arr == null || arr.length == 0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int ele:arr){
            set.add(ele);
        }
        for(int ele : set){
            //Checking ele is initial num of seq or not
            if(!set.contains(ele-1)){
                curNum = ele;
                curMax = 1;
                // checking its next num 
                while(set.contains(curNum+1)){
                    curNum++;
                    curMax++;
                }
                max = Math.max(max,curMax);
            }
        }
        return max;
    }
}