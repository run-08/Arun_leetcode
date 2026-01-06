class Solution {
    Map<Integer,Integer> map;
    int maxLevel = 0;
    public int maxLevelSum(TreeNode root) {
        map = new HashMap<>();
        int max = Integer.MIN_VALUE,maxIdx=0;
        helper(root,1);
        for(int i=1;i<=maxLevel;i++) {
           int sumLevel = map.get(i);
           if(sumLevel > max){
               max = sumLevel;
               maxIdx=i;
           }
        }
        return maxIdx;
    }
    private void helper(TreeNode root,int level){
        if(root== null) return;
        maxLevel = Math.max(maxLevel,level);
        int sum = map.getOrDefault(level,0)+root.val;
        map.put(level,sum);
        helper(root.left,level+1);
        helper(root.right,level+1);
    }
    
}