class Solution:
    def findEquilibrium(self, arr):
        # code here
        left_sum = 0
        ryt_sum = sum(arr)
        for i in range(len(arr)):
            ryt_sum -= arr[i]
            if left_sum == ryt_sum:
                return i
            left_sum += arr[i]
        return -1
