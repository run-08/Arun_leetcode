class Solution {
    public void nextPermutation(int[] nums) {
        int ind = Integer.MIN_VALUE;
        for(int i = nums.length-1;i >= 1;i--){
            if(nums[i] > nums[i-1]){
                ind = i-1;
                break;
            }
        }
        if(ind == Integer.MIN_VALUE){
            for(int i = 0;i < nums.length/2;i++) {
                int temp = nums[i];
                nums[i] = nums[nums.length-i-1];
                nums[nums.length-i-1] = temp;
            }
        }
      else {
        int position = ind;
      for(int i = nums.length-1;i >= ind+1;i--){
           if(nums[i] > nums[ind]){
            position = i;
            break;
           }
      }
      int temp = nums[ind];
      nums[ind] = nums[position];
      nums[position] = temp;
        int s = ind+1;
        int e = nums.length-1;
        while(s < e){
             temp = nums[s];
            nums[s] = nums[e];
            nums[e]  = temp;
            s++;
            e--;
        } 
    }
    }

}