class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        for(int student : students) q.offer(student);
        int idx = 0;
        int n = sandwiches.length;
         while(idx < n){
            if(!q.contains(sandwiches[idx])) break;
            if(q.peek() == sandwiches[idx]){
                q.poll();
                idx++;
                continue;
            }
            q.offer(q.poll());
         }
         return q.size();
    }
}