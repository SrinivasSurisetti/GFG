class Solution:
    def minSwaps(self, arr):
        n = len(arr)
        k = arr.count(1)

        if k == 0:
            return -1
        
        ones = sum(arr[:k])
        max_ones = ones
        
        for i in range(1, n - k + 1):
            
            #chesking before element of window
            if arr[i - 1]:
                ones -= 1
            
            #chesking window immediat next element
            if arr[i + k -1]:
                ones += 1
                
            max_ones = max(max_ones, ones)
            
        return k - max_ones
        
        