class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        n=len(nums)
        ans=[]
        for i in range(n):
            if target==nums[i]:
                ans.append(i)
        if len(ans)>1:
            return [ans[0],ans[-1]]
        elif len(ans)==1:
            return[ans[0],ans[0]]
        else:
            return [-1,-1] 