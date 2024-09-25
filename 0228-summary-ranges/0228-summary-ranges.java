class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            int Data = nums[i];
            int prev = nums[i];
            while(i+1 < nums.length){
                if(nums[++i] != Data+1) {
                    --i;
                    break;
                }
                else Data = nums[i];
            }
            if(prev == Data) res.add(String.valueOf(Data));
            else res.add(String.valueOf(prev+"->"+String.valueOf(Data)));
        }
        return res;
    }
}