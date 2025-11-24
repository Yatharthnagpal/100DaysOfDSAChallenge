class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        k=k%(len(nums))
        if k!=0:
            for _ in range(k):
                temp=nums.pop()
                nums.insert(0,temp)
        


        