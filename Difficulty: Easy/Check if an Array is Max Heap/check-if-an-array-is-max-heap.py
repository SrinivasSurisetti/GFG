class Solution:
    def isMaxHeap(self, arr):
        # code here
        n = len(arr)
        for i in range((n - 2) // 2 + 1):
            left = 2*i + 1
            ryt = 2*i + 2
            
            if left < n and arr[i] < arr[left]:
                return False
            
            if ryt < n and arr[i] < arr[ryt]:
                return False
            
        return True