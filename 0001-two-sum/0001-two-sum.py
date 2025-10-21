class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        n=len(nums)
        for i in range(n):
            rem = target-nums[i]
            if rem in nums and i!=nums.index(rem):
                return [i,nums.index(rem)]
            else:
                i+=1