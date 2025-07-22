#User function Template for python3

class Solution:
    #Function to rotate an array by d elements in counter-clockwise direction. 
    def rotateArr(self, arr, d):
        #Your code here
        n = len(arr)
        d %= n
    
        def rotate(arr,st,end):
            while st<end:
                arr[st],arr[end] = arr[end],arr[st]
                st += 1
                end -= 1
        rotate(arr,0,d-1)
        rotate(arr,d,n-1)
        rotate(arr,0,n-1)    