class Solution {
    public int snakesAndLadders(int[][] board) {
        HashMap<Integer , Integer > hm = new HashMap<>();
       int n = board.length;
       for(int i = n-2;i >= 0;i-=2){
            int[] row = board[i];
            for(int j = 0;j < n/2;j++) {
                int temp = row[j];
                row[j] = row[n-1-j];
                row[n-1-j] = temp;
            }
       }
       int idx = 1;
       for(int i = n-1;i >= 0;i--){
         int[] row = board[i];
         for(int cell : row) hm.put(idx++ , cell);
       }
      Queue<int[]>  q = new LinkedList<>();
      HashSet<Integer > visited = new HashSet<>();
      q.offer(new int[]{1,0});
      int res = ( n*n ) + 1;
      while(!q.isEmpty()){
        int[] cell = q.poll(); 
        if((cell[0] == n*n)) return cell[1];
        int pos = cell[0] , steps = cell[1];
        for(int i = 1;i <= 6 && pos+i <= n * n;i++) {
            int next = pos + i;
            int val = hm.get(next);
            if(val != -1) next = val;
            if(!visited.contains(next)){
                visited.add(next);
                q.offer(new int[]{next , steps+1});
            }
        }
      }
     return -1 ;
    }   
}