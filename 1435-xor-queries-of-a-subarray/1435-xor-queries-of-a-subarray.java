class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
       int res[] = new int[queries.length];
       int Data[] = new int[arr.length];
       Data[0]=arr[0];
    for(int i = 1;i < Data.length;i++) Data[i] = Data[i-1] ^ arr[i];
       for(int i = 0;i < queries.length;i++){
        if(queries[i][0] == queries[i][1]){
            res[i] = arr[queries[i][0]];
            continue;
        }
        if(queries[i][0] == 0){
            res[i] = Data[queries[i][1]];
            continue;
        }
        res[i] = Data[queries[i][1]] ^ Data[queries[i][0]-1];
       }
       return res;
    }
}