//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            String str = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine().trim());
            Solution obj = new Solution();
            if (obj.kPangram(str, k))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    boolean kPangram(String str, int k) {
        
       Set<Character> uniqueChars = new HashSet<>();
        int letterCount = 0;
        
        // Count unique alphabetic characters in the string and total alphabetic characters
        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch)) {
                uniqueChars.add(ch);
                letterCount++;
            }
        }
        
        // Number of unique characters needed to form a pangram
        int uniqueCount = uniqueChars.size();
        int requiredNewChars = 26 - uniqueCount;
        
        // Check if there are enough characters to replace and form a pangram
        return requiredNewChars <= k && letterCount >= 26;
    }
}