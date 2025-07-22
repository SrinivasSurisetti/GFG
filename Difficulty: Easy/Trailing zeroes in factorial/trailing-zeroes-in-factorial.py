import math
class Solution:
    def trailingZeroes(self, n):
    	#code here 
    	if n<0:
    	    return -1
    	count = 0
    	while(n>=5):
    	    n //= 5
    	    count += n
    	return count