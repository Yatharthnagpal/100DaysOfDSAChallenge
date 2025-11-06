class Solution:
    def reverse(self, x: int) -> int:
        ans=0
        def prevse(self,x:int):
            r=0
            while x>0:
                r=(x%10)+r*10
                x=x//10
            return r
            
        if x>=0:
            ans= prevse(self,x)
        if x<0:
            ans= (-1)*(prevse(self,abs(x)))
        if ans>2**31 or ans<-2**31:
            return 0
        return ans