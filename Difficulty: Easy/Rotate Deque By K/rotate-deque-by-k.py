class Solution:    
    def rotateDeque(self, dq, type, k):
        #code here
        n = len(dq)
        k %= n
        if type == 1:
            dq.rotate(k) #ryt
        else:
            dq.rotate(-k) #left
        return dq
        # if type == 1:
        #     return list(dq[n-k:]+dq[:n-k])
        # else:
        #     return list(dq[:n-k]+dq[n-k:])
