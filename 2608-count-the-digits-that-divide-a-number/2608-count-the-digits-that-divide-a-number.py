class Solution:
    def countDigits(self, num: int) -> int:
        n=num
        c=0
        while num>0:
            a=num%10
            if n%a==0:
                c+=1
            num=num//10  
        return c
              
