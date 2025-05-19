class Solution {
    public String triangleType(int[] nums) { 
       int min1 = 101;
       int min2 = 101;
       int max = -1;
       for(int val : nums) {
        if(val <= min1) {
            min2 = min1;
            min1 = val;
        }
        else if(val < min2) min2 = val; 
        max = Math.max(val , max);
       }
       int len = min1+min2;
    //    System.out.print(min1+" "+min2+" "+max);
       if(nums[0] == nums[1] && nums[1] == nums[2]) return "equilateral";
       if(max >= len) return "none";
         else return (nums[0] != nums[1] && nums[0] != nums[2]  && nums[1] != nums[2]) ?  "scalene" : "isosceles"; 
    }
}