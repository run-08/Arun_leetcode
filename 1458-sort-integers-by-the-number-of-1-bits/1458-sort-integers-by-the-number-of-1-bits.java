class Solution {
    public int[] sortByBits(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer , List<Integer>> hm = new HashMap<>();
        for(int val : arr){
            int temp = val;
            int no_of_ones = 0;
             while(val != 0){
                no_of_ones += (val % 2 != 0) ? 1 : 0;
                val /= 2;
             }
             if(!hm.containsKey(no_of_ones)) pq.offer(no_of_ones);
             List<Integer> ls = new ArrayList<>();
             if(hm.containsKey(no_of_ones)) ls = hm.get(no_of_ones); 
             ls.add(temp);
             hm.put(no_of_ones, new ArrayList<>(ls));
        }
        int idx = 0;
        // System.out.print(hm);
        while(!pq.isEmpty()){
           List<Integer> ls = hm.get(pq.poll());
           Collections.sort(ls);
           for(int i = 0;i < ls.size();i++) arr[idx++] = ls.get(i);
        }
        return arr;
    }
}