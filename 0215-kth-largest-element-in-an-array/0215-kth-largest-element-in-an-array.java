class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pr = new PriorityQueue<>();
        for(int val : nums) pr.add(val);
        int data = 0;
        int length = nums.length-k;
        while(length+1 != 0){
            data = (int)pr.poll();
            // System.out.print(data);
            length--;
        }
        return data;
    }
}