class Solution:
    def isPalindrome(self, x: int) -> bool:
        r=0
        temp=x
        while x>0:#1
            r=(x%10)+r*10  #r=1+54320  
            x=x//10 #x=0 r=54321
        return (r==temp)




