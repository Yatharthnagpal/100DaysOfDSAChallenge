# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        ans=[]
        if root is None:
            return ans
        arr=[]
        arr.append(root)
        while len(arr)>0:
            level=[]
            for _ in range(len(arr)):
                front=arr.pop(0)
                level.append(front.val)
                if front.left!=None:
                    arr.append(front.left)
                if front.right!=None:
                    arr.append(front.right)
            ans.append(level)
        return ans