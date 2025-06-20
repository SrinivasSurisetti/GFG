from collections import Counter
class Solution:
    def validgroup(self, arr ,k):
        # Code here
        if len(arr)%k != 0:
            return False
        arr.sort()
        count = Counter(arr)
        for num in arr:
            if count[num] == 0:
                continue
            for i in range(num,num+k):
                if count[i] == 0:
                    return False
                count[i] -= 1
        return True