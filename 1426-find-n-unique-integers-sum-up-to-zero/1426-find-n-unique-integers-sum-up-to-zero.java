class Solution {
    public int[] sumZero(int n) {
        int res[] = new int[n];
        for(int i = 1;i <= res.length/2;i++){
            res[i-1] = i-(i+i);
            res[--n] = i;
        }
        return res;
    }
}