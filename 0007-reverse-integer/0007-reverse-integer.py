class Solution:
    def reverse(self, x: int) -> int:
        ans=0
        if x>0:
            r=0 
            while x>0:
              r = (x%10) + r*10
              x = x//10
            ans=r 
        else:
            y=abs(x)
            r=0 
            while y>0:
              r = (y%10) + r*10
              y = y//10
            ans=-r
        if ans>((2**31)-1) or ans<(-2**31):
            ans = 0  
        return ans