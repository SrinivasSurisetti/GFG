#User function Template for python3

class Solution:
    def minxorpair (self, N, arr):
        # code here 
        min_val = int(sys.float_info.max)
        arr.sort()
        for i in range(0,N-1):
            val = arr[i] ^ arr[i+1]
            min_val = min(min_val,val)
        return min_val;
        
        