class Solution:
    def insertionSort(self, arr):
        # code here
        for i in range(0,len(arr)):
            for j in range(i,0,-1):
                if j>0 and arr[j-1] > arr[j]:
                    arr[j], arr[j-1] = arr[j-1], arr[j]