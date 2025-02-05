class Solution {
    public List<Integer> getRow(int numRows) {
          List<List<Integer>> dp = new ArrayList<>();
          List<Integer> ls = new ArrayList<>();
        ls.add(1);
        if(numRows == 0) return ls;
        dp.add(new ArrayList<>(ls));
        ls.remove(0);
        for(int i = 1;i <= numRows;i++){
           ls = dp.get(i-1);
           List<Integer> singleRow = new ArrayList<>();
           singleRow.add(1);
           int size = ls.size()-1;
           for(int j = 0;j < size;j++) singleRow.add(ls.get(j)+ls.get(j+1));
           singleRow.add(1);
           dp.add(new ArrayList<>(singleRow));
        }
        return dp.get(numRows);
    }
}