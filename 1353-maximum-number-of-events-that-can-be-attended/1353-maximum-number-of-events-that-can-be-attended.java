class Solution {
    public int maxEvents(int[][] events) {
        // Declartion...
        int attended = 0,n = events.length,idx=0,max =Arrays.stream(events)
                .flatMapToInt(Arrays::stream)
                .max()
                .orElse(0);
        System.out.print(max);
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        // logic...
        // sort first...
        Arrays
           .sort( events, (a,b) ->Integer.compare(a[0],b[0]));
        System.out.print(Arrays.deepToString(events));
        for(int i=1;i<=max;i++){
            // add meeting starts from i...
            while(idx < n && events[idx][0] <= i) {
                minHeap.offer(events[idx][1]);
                idx++;
            }
            // remove expired date...
            while(!minHeap.isEmpty() && minHeap.peek() < i) {
                minHeap.poll();
            }
            // Poll earliest possible...
            if(!minHeap.isEmpty()){
                minHeap.poll();
                attended++;
            } 
            // terminate earlier...
            // if(idx >= n && minHeap.isEmpty()) break;
        }
        return attended;
    }
}