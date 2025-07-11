class Solution:
    def countConsec(self, n: int) -> int:
        # code here
        total = 2**n
        fib = [0,1]
        for i in range(2,n+3):
            fib.append(fib[i-1] + fib[i-2])
        no_consec = fib[n+2]
        return total - no_consec