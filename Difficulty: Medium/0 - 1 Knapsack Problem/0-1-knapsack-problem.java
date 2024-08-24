//{ Driver Code Starts
import java.io.*;
import java.util.*;

class gfg {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int w = Integer.parseInt(br.readLine());

            String line = br.readLine();
            String[] tokens = line.split(" ");
            List<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] val = new int[array.size()];
            int idx = 0;
            for (int i : array) val[idx++] = i;

            String lin = br.readLine();
            String[] toke = lin.split(" ");
            List<Integer> array1 = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : toke) {
                array1.add(Integer.parseInt(token));
            }

            int[] wt = new int[array1.size()];
            idx = 0;
            for (int i : array1) wt[idx++] = i;

            // calling method knapSack() of class Solution
            System.out.println(new Solution().knapSack(w, wt, val));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[]) {
        
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];

        // Build the dp array bottom-up
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][W];
        
        // __________________________________________
        // your code here
        // int[] ar = val;
        // int score = 0;
        // Arrays.sort(val);
        // Integer[] intarr = Arrays.stream(ar).boxed().toArray(Integer[]::new);
        // for(int i = val.length - 1;i>=0;i--){
        //     int index = Arrays.asList(intarr).indexOf(val[i]);
        //     if(wt[index] <= W){ //&& val[i]<=W   score<=W && 
        //         score+=val[i];
        //         W-=wt[index];
        //     }            
        // }
        // return score;
        // __________________________________________________
        // Integer[] indices = new Integer[wt.length];
        // for(int i = 0;i<wt.length;i++){
        //     indices[i]=i;
        // }
        // Arrays.sort(indices,(i,j)->{
        //     double r1 = (double) val[i]/wt[i];
        //     double r2 = (double) val[j]/wt[j];
        //     return Double.compare(r2,r1);
        // });
        // int maxval = 0;
        // for(int i : indices){
        //     if(wt[i] <= W){
        //         maxval+=wt[i];
        //         W-=wt[i];
        //     }
        // }
        // return maxval;
    }
}
