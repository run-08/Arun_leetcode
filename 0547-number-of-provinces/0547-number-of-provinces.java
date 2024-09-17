class Solution {
    public int findCircleNum(int[][] arr) {
       int[] count ={0};
       HashSet<Integer> hs = new HashSet<>();
       for(int i = 0;i < arr.length;i++) dfs(arr,i,count,hs);
        return count[0];
    }
    public void dfs(int[][] arr,int index,int[] count,HashSet<Integer> hs){
           if(!hs.contains(index)) count[0] += 1;
            for(int j = 0;j < arr[index].length;j++){
                if(arr[index][j] == 0 || hs.contains(j)) continue;
                else{ 
                    hs.add(j);
                    dfs(arr,j,count,hs);
                }
            }
    }
}