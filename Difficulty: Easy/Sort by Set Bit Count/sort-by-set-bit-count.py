class Solution:
    def sortBySetBitCount(self, arr):
        # code here
        return sorted(arr, key = lambda x: bin(x).count('1'), reverse = True)