class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // declarion...
        Arrays.sort(meetings,(a,b) -> a[0] == b[0] ? Integer.compare(a[1],b[1]):Integer.compare(a[0],b[0]));
        PriorityQueue<RoomDetail> minHeap = new PriorityQueue<>((a,b) -> a.time != b.time ? Long.compare(a.time,b.time) : Long.compare(a.no,b.no));
        PriorityQueue<Integer> unUsedRoom  = new PriorityQueue<>((a,b) -> a - b );
        int[] roomUsed = new int[n];
        int max = 0, room = 0;
        // process...
        // Using TC increases...
        // Stream
        //       .iterate( 0, roomNo -> roomNo < n , roomNo -> roomNo + 1)
        //       .forEach( roomNo -> unUsedRoom.add(roomNo) );
        for(int i=0;i<n;i++) unUsedRoom.add(i);
        for(int[] meeting: meetings){
            // Because, if previous meeting was finished and still some room were free in unUsed mean, we failed to calculate that's why ae are using this logic....
            while (!minHeap.isEmpty() && minHeap.peek().time <= meeting[0]) {
                unUsedRoom.add(minHeap.poll().no);
            }
             if(unUsedRoom.isEmpty()){
                RoomDetail finished = minHeap.poll();
                int roomNo = finished.no;
                long time =  finished.time+(meeting[1]-meeting[0]);
                roomUsed[roomNo]++;
                minHeap.add(new RoomDetail(roomNo, time));
             }
            //  room is available...
             else {
                int roomNo = unUsedRoom.poll();
                roomUsed[roomNo]++;
                minHeap.add(new RoomDetail(roomNo,meeting[1]) );
             }
        }
        // Here, calculate the maximum used room....
        for(int i=0;i<n;i++){
            if(roomUsed[i] > max){
                max = roomUsed[i];
                room = i;
            }
        }
        return room;
    }
}
class RoomDetail{
    int no;
    long time;
    RoomDetail(int no,long time){
        this.no = no;
        this.time = time;
    }
}