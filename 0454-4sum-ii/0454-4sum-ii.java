class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Arrays.sort(nums3);
        Arrays.sort(nums4);
        HashMap<Integer,Integer> hm = new HashMap();
        int count = 0;
        for(int c : nums3)
            for(int d : nums4) hm.put((c+d),hm.getOrDefault(c+d,0)+1);
        for(int a : nums1) 
              for(int b : nums2)
                   count += hm.getOrDefault(-(a+b),0);
        return count;
    }
}