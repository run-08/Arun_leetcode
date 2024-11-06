class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
           HashMap<Integer , Integer> hm = new HashMap<>();
           HashMap<Integer , Integer> hm1 = new HashMap<>();
           for(int val : nums1) hm.put(val,hm.getOrDefault(val,0)+1);
           for(int val : nums2) hm1.put(val , hm1.getOrDefault(val,0)+1);
           int[] ans = {1,1};
           int freq = 0;
           for(int val : nums1) if(hm1.containsKey(val)) freq++;
           ans[0] = freq;
           for(int val : nums2) if(hm.containsKey(val)) freq++;
           ans[1] = freq - ans[0];
           return ans;
    }
}