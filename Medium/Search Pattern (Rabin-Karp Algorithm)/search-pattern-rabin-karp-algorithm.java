//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> search(String pattern, String text)
    {
        // your code here
        ArrayList<Integer> ar = new ArrayList<>();   
        // double ind = text.indexOf(pattern);
//         while(text.contains(pattern)){
//             ar.add(1+text.indexOf(pattern));
//             text1 = text1.replaceFirst(pattern,"");
//         }
//         return ar;
        int index = text.indexOf(pattern);
        while(index!=-1){
            ar.add(1+index);
            index = text.indexOf(pattern,index+1);
        }
        return ar;
    }
}