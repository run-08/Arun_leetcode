class Solution {
    public int numOfSubarrays(int[] arr) {
        // Daily Streak , I saw The u tube Solution
        int e = 1 , o = 0 , mod = 1000000007 , p_sum = 0 , result = 0;
        for(int val : arr){
            p_sum += val;
            if((p_sum & 1) == 0){
                result = (result+o) % mod;
                e++;
            }
            else{
                result = (result+e) % mod;
                o++;
            }
        }
        return result;
    }
}