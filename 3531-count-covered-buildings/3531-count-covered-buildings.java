class Solution {
    public int countCoveredBuildings(int n, int[][] arr) {
           Map<Integer,Deque<Integer>> vertical = new HashMap<>();
           Map<Integer,Deque<Integer>> horizontal = new HashMap<>();
           int res=0;
           Arrays.sort(arr,(a,b)->{
               if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);
               else return Integer.compare(a[1],b[1]);
           });
           for(int i=1;i<=n;i++){
            vertical.put(i,new ArrayDeque<>());
            horizontal.put(i,new ArrayDeque<>());
           }
           for(int[] a : arr) {
              vertical.get(a[1]).add(a[0]);
              horizontal.get(a[0]).add(a[1]);
           } 
           for(int[] a : arr){
               int row=a[0],col=a[1];
               if(horizontal.get(row).peekFirst() != col && horizontal.get(row).peekLast() != col){
                   if(vertical.get(col).peekFirst() != row && vertical.get(col).peekLast() != row) res++;
               }
           }
           return res;
    }
}