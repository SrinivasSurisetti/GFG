#User function Template for python3

class Solution:
    #Complete the below function
    def countDistinctPairs(self,arr, target):
        #Your code here
        seen = set()
        unique_pairs = set()
        
        for num in arr:
            complement = target - num
            if complement in seen:
                unique_pairs.add(tuple(sorted((num,complement)))) #for () purpose i use tuple
            seen.add(num)
        return len(unique_pairs)