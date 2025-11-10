class Solution:
    def isHappy(self, n: int) -> bool:
        a=set()
        while n!=1 and n not in a:
            a.add(n)
            s=0
            while n > 0:
                d = n % 10
                s += d * d
                n //= 10
            n=s
        return n==1    