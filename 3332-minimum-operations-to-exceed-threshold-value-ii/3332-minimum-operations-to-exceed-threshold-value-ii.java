class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pr =  new PriorityQueue<>();
        for(int val : nums) if(val < k) pr.offer((long)val);
        int cnt = 0;
        while(!pr.isEmpty()){
             cnt++;
             long e1 = pr.poll();
             if(pr.isEmpty()) break;
             long e2 = pr.poll();
             long min = (e1 <= e2) ? e1 : e2;
             long max = (e1 >= e2) ? e1 : e2;
             long val = (min*2)+max;
             if(val < k) pr.offer(val);
        }
        return cnt;
    }
}