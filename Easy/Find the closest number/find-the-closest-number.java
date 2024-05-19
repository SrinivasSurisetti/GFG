//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int k;
            k = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.findClosest(n, k, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findClosest(int n, int k, int[] arr) {
        int[] newarr = new int[n + 1];
        System.arraycopy(arr, 0, newarr, 0, n);
        newarr[n] = k;
        Arrays.sort(newarr);
        int index = Arrays.binarySearch(newarr, k);
        if (index == 0) {
            return newarr[index];
        } else if (index == n) {
            return newarr[n - 1];
        } else {
            int lowdiff = Math.abs(newarr[index] - newarr[index - 1]);
            int highdiff = Math.abs(newarr[index] - newarr[index + 1]);
            if (lowdiff >= highdiff) {
                return newarr[index + 1];
            } else {
                return newarr[index - 1];
            }
        }
    }
}

        
