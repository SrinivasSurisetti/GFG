#User function Template for python3
class Solution:

    def calculateFraction(self, a, b):
        # Code Here
        if a==0:
            return 0
        res = "-" if (a<0) ^ (b<0) else ""
        res += str(a//b)
        rem = a%b
        if rem == 0:
            return res
        res += "."
        mp = {}
        while rem>0:
            if rem in mp:
                res = res[:mp[rem]] + "(" + res[mp[rem]:] + ")" 
                break
            mp[rem] = len(res)
            rem = rem*10
            res += str(rem//b)
            rem %= b
        return res