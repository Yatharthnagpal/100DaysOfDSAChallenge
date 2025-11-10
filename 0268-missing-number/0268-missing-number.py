class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        nums.sort()
        if nums[0]!=0:
            return 0
        else:
            for i in range(0,len(nums)-1):
                if (nums[i]+1)!=nums[i+1]:
                    return nums[i]+1
            return nums[len(nums)-1]+1
