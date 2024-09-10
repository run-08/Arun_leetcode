class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> hs = new HashSet<>();
        for(int i = 0;i < nums.length-3;i++){
            for(int j = i+1; j < nums.length;j++){
                int s = j+1;
                int e = nums.length-1;
                while(s < e){
                    if((long)nums[i]+nums[j]+nums[s]+nums[e] == target){
                        hs.add(Arrays.asList(nums[i],nums[j],nums[s],nums[e]));
                        s++;
                    }
                    else if(nums[i]+nums[j]+nums[s]+nums[e] > target) e--;
                    else s++;
                }
            }
        }
        res = new ArrayList<>(hs);
        return res;
    }
}