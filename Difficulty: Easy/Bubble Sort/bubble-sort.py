class Solution:
    def bubbleSort(self,arr):
        # code here
        for i in range(len(arr)-1,0,-1):
            did_swap = 0
            for j in range(0,i):
                if arr[j] > arr[j+1]:
                    arr[j],arr[j+1] = arr[j+1],arr[j]
                    did_swap = 1
            if did_swap == 0:
                break