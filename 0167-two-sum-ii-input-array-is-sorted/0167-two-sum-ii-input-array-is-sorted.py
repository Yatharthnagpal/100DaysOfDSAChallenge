class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        n=len(numbers)
        for i in range(n):
            rem = target-numbers[i]
            if rem in numbers and i!=numbers.index(rem):
                arr=[i+1,numbers.index(rem)+1]
                arr.sort()
                return arr