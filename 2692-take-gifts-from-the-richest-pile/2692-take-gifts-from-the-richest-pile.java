class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)  -> b - a);
        for(int val : gifts) pq.offer(val);
        while(k != 0){
            pq.offer((int)Math.floor(Math.sqrt(pq.poll())));
            k--;
        }
        long sum = 0;
        while(!pq.isEmpty()) sum += pq.poll();
        return sum;
    }

}