class Solution {
    HashMap<Long , Integer> hm = new HashMap<>();
    long res = 0;
    public int pathSum(TreeNode root, int targetSum) {
        long sum = 0 ;
        hm.put(sum,1);
        pathsum(root, sum , targetSum);
        return (int)res;
    }
    public void pathsum(TreeNode root , long sum ,  int targetSum){
        if(root == null) return;
        sum += root.val;
        res += hm.getOrDefault(sum - targetSum, 0);
        hm.put(sum , hm.getOrDefault(sum , 0)+1);
        pathsum(root.left , sum , targetSum);
        pathsum(root.right , sum , targetSum);
        hm.put(sum , hm.get(sum)-1);
        if(hm.get(sum) <= 0)hm.remove(sum);
    }
}