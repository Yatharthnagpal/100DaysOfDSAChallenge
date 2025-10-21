class Solution:
    def fre(self,a:str):
        freq = {}
        for i in a:
            if i in freq:
                freq[i] += 1
            else:
                freq[i] = 1
        return freq
    def isAnagram(self, s: str, t: str) -> bool:
        fre1=self.fre(s)
        fre2=self.fre(t)
        if fre1==fre2:
            return True
        else:return False

