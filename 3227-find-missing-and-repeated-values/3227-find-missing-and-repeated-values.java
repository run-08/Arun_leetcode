class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] freq = new int[(n*n)+1];
        int res[] = new int[2];
        for(int[] arr : grid){
             int m = arr.length;
             for(int i = 0;i < m;i++) freq[arr[i]]++;
        }
        // System.out.print(Arrays.toString(freq));
        for(int i = 1;i < (n*n)+1;i++){
            if(freq[i] > 1) res[0] = i;
            else if(freq[i] == 0) res[1] = i;
        }
        return res;
    }
}