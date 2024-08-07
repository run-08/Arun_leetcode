class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> ls = new ArrayList<>();
        for(int i = 0;i < index.length;i++) ls.add(index[i],nums[i]);
        int[] res = new int[index.length];
        for(int i = 0;i < ls.size();i++) res[i] = (int)ls.get(i);
         return res;
    }
}