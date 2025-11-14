class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] arr = new int[n][n];
        for(int[] query : queries){
            int row1=query[0],col1=query[1],row2=query[2],col2=query[3];
            while(row1 <= row2){
                arr[row1][col1] += 1;
                if(col2+1<n) arr[row1][col2+1] -= 1;
                row1++;
            }
        }
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=0;j<n;j++){
                sum += arr[i][j];
                arr[i][j]=sum;
            }
        }
        // for(int[] a : ar) System.out.println(Arrays.toString(a));
        return arr;
    }
}