class Solution {
public:
    int minimumMountainRemovals(vector<int>& nums) {

        int numsSize = nums.size();

        vector<int> LIS( numsSize , 1 );
        vector<int> LDS( numsSize , 1 );

        // LIS
        for ( int index = 0 ; index < numsSize ; index++) for ( int index1 = 0 ; index1 < index ; index1++ ) if ( nums [ index ] > nums [ index1 ] ) LIS [ index ] = max ( LIS [ index ] , LIS [ index1 ] + 1 );

        // LDS
        for ( int index = numsSize -1 ; index >= 0 ; index-- ) for ( int index1 = numsSize - 1 ; index1 > index ; index1-- ) if ( nums [ index ] > nums [ index1 ] ) LDS [ index ] = max ( LDS [ index ] , LDS [ index1 ] + 1 );

        int minimumMountainRemovals = 0;
        
        

        for ( int index = 0 ; index < numsSize ; index++ ) if ( LIS [ index ] > 1 && LDS [ index ] > 1 ) minimumMountainRemovals = max ( minimumMountainRemovals , LIS [ index ] + LDS [ index ] - 1 );

        return numsSize - minimumMountainRemovals;
    }
};