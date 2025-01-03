class Solution {
    public long maximumImportance(int n, int[][] roads) {
        // HashSet<Integer> hs = new HashSet<>();
        HashMap<Integer , Integer> hm = new HashMap<>();
        PriorityQueue<Integer> pr = new PriorityQueue<>((a,b) -> hm.get(b) - hm.get(a));
      for(int[] arr : roads) {
         hm.put(arr[0],hm.getOrDefault(arr[0],0)+1);
         hm.put(arr[1],hm.getOrDefault(arr[1],0)+1);
      }
      HashSet<Integer> hs = new HashSet<>();
      for(int[] arr : roads) {
        if(!hs.contains(arr[0])) {
            pr.offer(arr[0]);
            hs.add(arr[0]);
        }
         if(!hs.contains(arr[1])) {
            pr.offer(arr[1]);
            hs.add(arr[1]);
        }
      }
      while(!pr.isEmpty() )hm.put(pr.poll() , n--);
      long imp = 0;
      for(int[] arr : roads) imp += hm.get(arr[0])+hm.get(arr[1]);
      return imp;
    }
}