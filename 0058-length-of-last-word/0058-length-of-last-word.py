class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        s=(s.strip()).split()
        a=s[len(s)-1]
        return len(a)