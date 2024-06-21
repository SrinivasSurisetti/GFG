//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    String compareFrac(String str) {
        // Code here
        String[] fractions = str.split(", ");
        String fraction1 = fractions[0];
        String fraction2 = fractions[1];
        
        String[] a_values = fraction1.split("/");
        int a = Integer.parseInt(a_values[0]);
        int b = Integer.parseInt(a_values[1]);
        
        String[] b_values = fraction2.split("/");
        int c = Integer.parseInt(b_values[0]);
        int d = Integer.parseInt(b_values[1]);
        
        double value1 = (double) a/b;
        double value2 = (double) c/d;
        
        if(value1>value2){
            return fraction1;
        }
        else if(value2 > value1){
            return fraction2;
        }
        else{
            return "equal";
        }
    }
}
