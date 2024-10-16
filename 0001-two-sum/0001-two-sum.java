class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer>map = new HashMap<>();
        int complement,currentNumber;
        int[] resultindex = new int[2];
        for(int i =0;i<nums.length;i++){
              currentNumber = nums[i];
              complement = target-currentNumber;
              if(map.containsKey(complement)){
                  resultindex[0] = i;
                  resultindex[1] = map.get(complement);
                  return resultindex;
              }
          else{
            map.put(currentNumber,i);
          }        
       }
       return new int[]{-1, -1};
    }
}