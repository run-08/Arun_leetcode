import java.util.HashMap;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> ele = new HashSet<>();
        if(nums.length < 3) return res;
        Arrays.sort(nums);
        for(int i = 0;i < nums.length-2;i++){
              int left = i+1;
              int right = nums.length-1;
              while(left < right){
                    int sum = nums[i]+nums[left]+nums[right];
                    if(sum == 0){
                         ele.add(Arrays.asList(nums[i],nums[left],nums[right]));
                         right--;
                    }
                    else if(sum < 0)left++;
                    else right--;
              }
        }
        res = new ArrayList<>(ele);
        return res;
    }
}