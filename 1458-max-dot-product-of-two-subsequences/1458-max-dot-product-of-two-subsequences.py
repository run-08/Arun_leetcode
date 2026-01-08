class Solution:
    
    def maxDotProduct(self, nums1: List[int], nums2: List[int]) -> int:
        self.n1 = len(nums1)
        self.n2 = len(nums2)
        self.nums1 = nums1
        self.nums2 = nums2
        self.dp = [ [-1 for _ in range(0,self.n2)] for _ in range(0,self.n1)]
        return self.helper(0,0)
    def helper(self,idx1: int,idx2:int) -> int:
        if(idx1 >= self.n1 or idx2 >= self.n2): return -10000000
        if(self.dp[idx1][idx2] != -1): return self.dp[idx1][idx2]
        best: int = self.nums1[idx1] * self.nums2[idx2]
        # took...
        took: int = self.helper(idx1+1,idx2+1)
        # non_took... 2 possibilities...
        not_took: int = max(self.helper(idx1+1,idx2),self.helper(idx1,idx2+1))
        best += max(took,0)
        self.dp[idx1][idx2] = max(best,not_took)
        return self.dp[idx1][idx2]
