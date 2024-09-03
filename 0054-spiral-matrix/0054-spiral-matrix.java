class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        right(0,matrix.length-1,0,matrix[0].length-1,res,matrix);
        return res;
    }
    public void right(int rowstart,int rowend,int colstart,int colend,List<Integer> ls,int[][] arr){
        if(rowstart > rowend || colstart > colend) return;
        for(int i = colstart;i <= colend;i++) ls.add(arr[rowstart][i]);
        rowstart++;
        down(rowstart,rowend,colstart,colend,ls,arr);
    }
    public void down(int rowstart,int rowend,int colstart,int colend,List<Integer> ls,int[][] arr){
        if(rowstart > rowend || colstart > colend) return;
        for(int i = rowstart;i <= rowend;i++) ls.add(arr[i][colend]);
        colend--;
        left(rowstart,rowend,colstart,colend,ls,arr);
    }
    public void left(int rowstart,int rowend,int colstart,int colend,List<Integer> ls,int[][] arr){
        if(rowstart > rowend || colstart > colend) return;
        for(int i = colend;i >= colstart;i--) ls.add(arr[rowend][i]);
        rowend--;
        up(rowstart,rowend,colstart,colend,ls,arr);
    }
    public void up(int rowstart,int rowend,int colstart,int colend,List<Integer> ls,int[][] arr){
        if(rowstart > rowend || colstart > colend) return;
        for(int i = rowend;i >= rowstart;i--) ls.add(arr[i][colstart]);
        colstart++;
        right(rowstart,rowend,colstart,colend,ls,arr);
    }
}