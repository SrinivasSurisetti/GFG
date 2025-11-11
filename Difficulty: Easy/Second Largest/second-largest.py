class Solution:
    def getSecondLargest(self, arr):
        # Code Here
        largest = float("-inf")
        second_largest  = float("-inf")
        
        for num in arr:
            if num > largest:
                second_largest = largest
                largest = num
            elif num > second_largest and num != largest:
                second_largest = num
        
        if second_largest == float("-inf"):
            return -1
        return second_largest