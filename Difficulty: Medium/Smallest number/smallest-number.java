//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int s = sc.nextInt();
            int d = sc.nextInt();

            Solution obj = new Solution();
            String res = obj.smallestNumber(s, d);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends



class Solution {
    public String smallestNumber(int s, int d) {
        // code here
        if(s<1 || s>9*d){
            return "-1";
        }
        int[] dig = new int[d];
        s -= 1;
        for(int j =d-1;j>0;j--){
            if(s>9) {
                dig[j]=9;
                s-=9;
            }
            else {
                dig[j]=s;
                s=0;
            }
        }
        dig[0] = s+1;
        StringBuilder str = new StringBuilder();
        for(int digit:dig){
            str.append(digit);
        }
        return str.toString();
    }
}
