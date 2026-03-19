#User function Template for python3

class Solution:
    def replaceWithRank(self, N, arr):
        # Code here
        res = {key: val + 1 for val, key in enumerate(sorted(set(arr)))}
        return [res[x] for x in arr]