class Solution:
 
    def mergeSort(self, arr, l, r):
        #code here
        if l==r:
            return
        mid = (l+r)//2
        self.mergeSort(arr,l,mid)
        self.mergeSort(arr,mid+1,r)
        self.merge(arr,l,mid,r)
    
    def merge(self, arr, l, mid, h):
        left = l
        ryt = mid + 1
        temp = []
        while left <= mid and ryt <= h:
            if arr[left] <= arr[ryt]:
                temp.append(arr[left])
                left += 1
            else:
                temp.append(arr[ryt])
                ryt += 1
        while(left <= mid):
            temp.append(arr[left])
            left += 1
        while(ryt <= h):
            temp.append(arr[ryt])
            ryt += 1
        for i in range(l,h+1):
            arr[i] = temp[i - l]