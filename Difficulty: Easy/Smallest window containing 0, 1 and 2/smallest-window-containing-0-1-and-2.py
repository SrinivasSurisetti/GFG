class Solution:
    def smallestSubstring(self, s):
        # code here
        left = 0
        count = {'0':0, '1': 0 , '2': 0}
        min_val = float('inf')
        
        for ryt in range(len(s)):
            if s[ryt] in count:
                count[s[ryt]] += 1
            while all(count[c] > 0 for c in '102'):
                min_val = min(min_val, ryt - left + 1)
                if s[left] in count:
                    count[s[left]] -= 1
                left += 1
        return -1 if min_val == float('inf') else min_val