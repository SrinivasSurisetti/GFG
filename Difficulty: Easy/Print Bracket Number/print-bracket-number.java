//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            ArrayList<Integer> result = ob.bracketNumbers(S);
            for (int value : result) out.print(value + " ");
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Integer> bracketNumbers(String str) {
        // code here
        int count = 0;
        ArrayList<Integer> ar = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='('){
                count++;
                st.push(count);
                ar.add(count);
            }
            else if(ch==')'){
                if(!st.isEmpty())
                ar.add(st.pop());
            }
        }
        return ar;
    }
};