class FindSumPairs {
     
    HashMap < Integer , Integer > nums2Freq;
    int[]  nums2 , nums1;

    public FindSumPairs(int[] nums1, int[] nums2) {
         nums2Freq = new HashMap<>();
         this.nums2 = nums2;
         this.nums1 = nums1;
         for( int num : nums2 ) nums2Freq.put ( num , nums2Freq.getOrDefault( num , 0  ) + 1 );
         Arrays.sort( nums1 );
    }
    
    public void add(int index, int val) {
        int oldElement = nums2 [ index ];
        nums2Freq.put( oldElement , nums2Freq.get( oldElement ) - 1 );
        if( nums2Freq.get(  oldElement ) == 0 ) nums2Freq.remove( oldElement );
        nums2 [ index ] += val;
        nums2Freq.put( nums2[index]  , nums2Freq.getOrDefault( nums2 [ index ] , 0 ) + 1); 
    }
    
    public int count(int tot) {
       int totalCount = 0;
       for ( int value : nums1 ) {
           if( value > tot ) break;
           int complement = tot - value ;
           if( nums2Freq.containsKey ( complement ) ) totalCount += nums2Freq.get( complement );
       }
       return totalCount;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */