class Solution {
    public int findShortestSubArray(int[] nums) {
        if(nums.length == 1) return 1;
        HashMap<Integer,List<Integer>> hm = new HashMap<>();
        int max_freq = 0;
        for(int i = 0;i < nums.length;i++){
            if(hm.containsKey(nums[i])){
                List<Integer> ls = hm.get(nums[i]);
                ls.set(2,ls.get(2)+1);
                ls.set(1,i);
                if(max_freq < ls.get(2)) max_freq = ls.get(2);
                hm.put(nums[i],new ArrayList<>(ls));
            }else {
                List<Integer> ls = new ArrayList<>();
                ls.add(0,i);
                ls.add(1,i);
                ls.add(2,1);
                 if(max_freq < ls.get(2)) max_freq = ls.get(2);
                hm.put(nums[i],new ArrayList<>(ls));
            }
        }
        if(max_freq == 1) return 1;
        int idx = 0;
       HashMap<Integer , List<Integer>> freq = new HashMap<>();
        for(int i = 0;i < nums.length ; i++){
            if(hm.containsKey(nums[i])) {
                if(hm.get(nums[i]).get(2) == max_freq) freq.put(idx++ , hm.get(nums[i]));
                hm.remove(nums[i]);
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0;i < freq.size();i++) if(res > (freq.get(i).get(1) - freq.get(i).get(0))) res = (freq.get(i).get(1) - freq.get(i).get(0));
        return res+1;
    }
}
