class Solution: 
    def selectionSort(self, arr):
        #code here
        for i in range(len(arr)-1):
            unsortedArr = arr[i:]
            minVal = min(unsortedArr)
            minIndex = unsortedArr.index(minVal)
            arr[i], arr[i+minIndex] = minVal, arr[i]
        