class Solution {
    public List<List<Integer>> permute(int[] nums) {
      List<Integer> map = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        boolean freq[] = new boolean[n];
        recursionPermutate(map , res , freq , nums);
    return (res);
	}

	private static void recursionPermutate(List<Integer> map, List<List<Integer>> res, boolean[] freq, int[] nums) {
		if(map.size() == nums.length) {
			 res.add(new ArrayList<>(map));
			 return ;
		}
		int n = nums.length;
		for(int i  = 0;i < n;i++) {
			if(!freq[i]) {
				freq[i] = true;
				map.add(nums[i]);
				recursionPermutate(map , res , freq , nums);
				freq[i] = false;
				map.remove(map.size()-1);
			}
		}
    }
}