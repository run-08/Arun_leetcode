class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        HashMap<Integer , int[][]> hm = new HashMap<>();
        for(int[] arr : queries) {
            int[][] freq = hm.getOrDefault(arr[0] , new int[1][2]);
            freq[0][0]++;
            hm.put(arr[0] , freq.clone());
            freq = hm.getOrDefault(arr[1] , new int[1][2]);
            freq[0][1]++;
            hm.put(arr[1] , freq.clone());
        }
        int differer = 0 ,  n = nums.length;
        for(int i = 0;i < n;i++){
            if(hm.containsKey(i)) differer += hm.get(i)[0][0];
            nums[i] -= differer;
            if(hm.containsKey(i)) differer -= hm.get(i)[0][1];
        }
        for(int  val : nums) if(val > 0) return false;
        return true;
    }
}