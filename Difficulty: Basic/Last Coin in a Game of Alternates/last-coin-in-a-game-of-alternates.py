class Solution:
    def coin(self, arr):
        # code here
        n = len(arr)

        left = 0
        ryt = n - 1
        while left < ryt:
            if arr[left] >= arr[ryt]:
                left += 1
            else:
                ryt -= 1
        return arr[ryt]
            