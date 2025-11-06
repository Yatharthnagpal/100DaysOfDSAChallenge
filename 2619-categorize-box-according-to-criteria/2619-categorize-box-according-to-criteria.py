class Solution:
    def categorizeBox(self, l: int, w: int, h: int, m: int) -> str:
        isBulky=False
        isheavy=False

        if (l*h*w)>=10**9 or l>=10**4 or w>=10**4 or h>=10**4:
            isBulky=True
        if m>=100:
            isheavy=True
        
        if isheavy==True and isBulky==True:
            return "Both"
        if isheavy!=True and isBulky!=True:
            return "Neither"
        if isheavy==True and isBulky!=True:
            return "Heavy"
        if isheavy!=True and isBulky==True:
            return "Bulky"    
