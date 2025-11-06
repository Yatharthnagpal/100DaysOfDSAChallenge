class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        a=len(nums)
        for _ in range(k):
            temp=nums.pop(a-1)
            nums.insert(0,temp)


        