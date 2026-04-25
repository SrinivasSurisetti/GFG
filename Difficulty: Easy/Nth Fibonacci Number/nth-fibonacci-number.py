class Solution:
    def nthFibonacci(self, n: int) -> int:
        # code here
        a, b = 0, 1
        for i in range(n):
            a, b =  b, a+b
        return a