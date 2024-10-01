class Solution {
    public int thirdMax(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        Arrays.sort(nums);
        for(int val : nums){
            if(ls.size() == 0) ls.add(val);
            else if(ls.get(ls.size()-1) != val) ls.add(val);
        }
        return (ls.size() >= 3) ? ls.get(ls.size()-3) : ls.get(ls.size()-1);
    }
}