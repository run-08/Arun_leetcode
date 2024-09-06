class Solution {
    public int jump(int[] nums) {
        int cnt = 0;
        int pos = 0;
        while(pos < nums.length-1){
            cnt++;
            int pos_ele = nums[pos];
            if(pos_ele >=(nums.length-1) - pos) return cnt;
            int distance = Integer.MAX_VALUE;
            int distance_pos = pos;
            for(int i = pos;i <= (pos+pos_ele);i++){
                int distance_in = (((nums.length-1)-i) - nums[i]);
                if(distance > distance_in){
                    distance = distance_in;
                    distance_pos = i;
                }
              }
        
            pos = distance_pos;
         }
        return cnt;
    }
}