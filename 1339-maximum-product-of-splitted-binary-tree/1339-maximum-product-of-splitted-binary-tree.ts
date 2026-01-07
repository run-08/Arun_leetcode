/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */
function getTotalSum (root: TreeNode | null): number{
    if(root === null) return 0;
    return root.val+getTotalSum(root.left)+getTotalSum(root.right);
}
function maxProduct(root: TreeNode | null): number {
    // Get total sum...
    const totalSum: number = getTotalSum(root);
    // Get maximized product...
    let max: number = 0;
    let MOD: number = 1_000_000_007;
    function FindMaximized(root?: TreeNode | null): number{
      if(root===null) return 0;
      let leftSum: number = FindMaximized(root.left);
      let rightSum: number = FindMaximized(root.right);
      max = Math.max(max,((totalSum-leftSum)*leftSum),((totalSum-rightSum)*rightSum));
      let sum: number = root.val+leftSum+rightSum;
      return sum;
    }
    FindMaximized(root);
    return max % MOD; 
};

