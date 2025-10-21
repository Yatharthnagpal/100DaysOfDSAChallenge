class Solution:
    def countGoodSubstrings(self, s: str) -> int:
        n=len(s)
        c=0
        for i in range(0,n-2):
            if s[i]!=s[i+1] and s[i]!=s[i+2] and s[i+1]!=s[i+2]:
                c+=1
        return c
