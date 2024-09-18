class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        res.add(new ArrayList<>(ls));
        bacrec(nums,0,ls,res);
        return res;
    }
    public void bacrec(int[] nums,int index,List<Integer> temp,List<List<Integer>> res){
        for(int i = index;i < nums.length;i++){
            temp.add(nums[i]);
            res.add(new ArrayList<>(temp));
             bacrec(nums,i+1,temp,res);
            temp.remove(temp.size()-1);
        }
    }
}