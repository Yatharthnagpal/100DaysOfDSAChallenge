class Solution:
    def isValid(self, s: str) -> bool:
        if len(s)==0:
            return False
        st=[]
        for ch in list(s):
            if ch=="(" or ch=="{" or ch=="[":
                st.append(ch)
            else:
                if len(st)==0:
                    return False
                top =st.pop()
                if ch==")" and top!="(":
                    return False
                elif ch=="]" and top!="[":
                    return False
                elif ch=="}" and top!="{":
                    return False
        return len(st)==0
        
