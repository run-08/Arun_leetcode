class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        HashSet<Long> hs = new HashSet<>();
        for(int val : nums) hs.add((long)val);
        int  count = 0;
        for(int val : nums){
            int temp = 0;
            if(hs.contains((long)val)) temp = compute(val , hs);
            if(temp > count) count = temp;
        }
        return (count == 1) ? -1 : count;
    }
    public int compute(int val , HashSet<Long>hs){
       int count = 1;
       long longval = (long) val;
       while(hs.contains(longval * longval)){
         longval *= longval;
         count++;
       }
       return count;
    }
}