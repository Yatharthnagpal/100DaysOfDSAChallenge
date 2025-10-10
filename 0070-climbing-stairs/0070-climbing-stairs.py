class Solution:
    def climbStairs(self, n: int) -> int:
        if n==0 or n==1:
            return n
        n1=1
        n2=1
        a=0
        for i in range (n-1):
            a=n1+n2
            n1=n2
            n2=a
        return a    

        