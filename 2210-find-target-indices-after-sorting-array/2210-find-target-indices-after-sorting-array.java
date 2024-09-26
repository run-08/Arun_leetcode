class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
       List<Integer> res = new ArrayList<>();
       int count = 0;
       int  pos = 0;
       for(int val : nums){
        if(val < target) pos++;
        if(val == target) count++;
       }
       while(count-- != 0) res.add(pos++);
       return res;
    }
}