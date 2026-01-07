# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    max: int = 0
    totalSum: int = 0
    MOD: int = 1_000_000_007
    def maxProduct(self, root: Optional[TreeNode]) -> int:
        # Get all sum's value...
        self.totalSum = self.getSum(root)
        # Find maximized product...
        self.dfs(root)
        return self.max % self.MOD
        
    def getSum(self,root:Optional[TreeNode]) -> int:
        if(root==None): return 0
        return root.val+(self.getSum(root.left))+(self.getSum(root.right))

    def dfs(self,root:Optional[TreeNode]) -> int:
        if(root==None): return 0
        leftSum: int = self.dfs(root.left)
        rightSum: int = self.dfs(root.right)
        self.max = max(self.max,(self.totalSum-leftSum)*leftSum)
        self.max = max(self.max,(self.totalSum-rightSum)*rightSum)
        return leftSum+rightSum+root.val