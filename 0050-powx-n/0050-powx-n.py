class Solution:
    def myPow(self, x: float, n: int) -> float:
        
        if n==0:
            return 1
        elif n>0:
            a=self.myPow(x,n//2)    
            if n%2==0:
                return a*a
            else:
                return a*a*x
        else :
            b=n*-1
            a=self.myPow(x,b//2)
            
            if b%2==0:
                return 1/(a*a)
            else:
                return 1/(a*a*x)
