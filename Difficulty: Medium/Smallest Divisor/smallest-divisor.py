import math
class Solution:
    def smallestDivisor(self, arr, k):
        # Code here
        left,ryt = 1,max(arr)
        res = ryt
        def computeDivisor(divisor):
            return sum(math.ceil(num/divisor) for num in arr)
        while left <= ryt:
            mid = (left + ryt)//2
            if computeDivisor(mid) <= k:
                res = mid
                ryt = mid - 1
            else:
                left = mid+1
        return res
        # arr.sort()
        # newArr = arr[len(arr)//2:]
        # minValue = float('inf')
        # for divisor in newArr:
        #     total = 0
        #     for num in newArr:
        #         total += math.ceil(num/divisor)
        #     if total<=k:
        #         minValue = min(divisor,minValue)
        # return minValue
        
