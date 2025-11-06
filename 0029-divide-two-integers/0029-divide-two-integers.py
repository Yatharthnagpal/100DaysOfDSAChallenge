class Solution:
    def divide(self, d1: int, d2: int) -> int:
        if d1//d2==2**31:
            return (2**31)-1
        if d1<0 and d2<0:
            return (d1)//(d2)
        elif d1<0 or d2<0:
            return (-(abs(d1)//abs(d2)))
        else :
            return d1//d2