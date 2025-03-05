class Solution {
    HashMap<Integer , List<Integer>> col_contains_rows = new HashMap<>();
    HashMap<Integer , HashMap<Integer , List<Integer>>> cols = new HashMap<>();
    int min_depth = 1001;
    int max_depth = -1001;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root , 0 , 0);
        List<List<Integer>> result = new ArrayList<>();
        for(;min_depth <= max_depth;min_depth++){
            List<Integer> rows = col_contains_rows.get(min_depth);
            HashMap<Integer , List<Integer>> columns = cols.get(min_depth);
            List<Integer> res = new ArrayList<>();
            Collections.sort(rows);
            for(int row : rows){
               List<Integer> ls = columns.get(row);
               Collections.sort(ls);
               res.addAll(new ArrayList<>(ls));
            }
            result.add(new ArrayList<>(res));
        }
        return result;
    }
    public void dfs(TreeNode root , int row , int col){
      if(root == null) {
        min_depth = Math.min(min_depth , col+1);
        max_depth = Math.max(max_depth , col-1);
        return;
      }
      List<Integer> ls = col_contains_rows.getOrDefault(col , new ArrayList<>());
      if(!ls.contains(row))ls.add(row);
      col_contains_rows.put(col , new ArrayList<>(ls));
      HashMap<Integer , List<Integer>> hm = cols.getOrDefault(col , new HashMap<>());
      ls = hm.getOrDefault(row , new ArrayList<>());
      ls.add(root.val);
      hm.put(row , new ArrayList<>(ls));
      cols.put(col , new HashMap<>(hm));
      dfs(root.left , row+1 , col-1);
      dfs(root.right , row+1 , col+1);
    }
}