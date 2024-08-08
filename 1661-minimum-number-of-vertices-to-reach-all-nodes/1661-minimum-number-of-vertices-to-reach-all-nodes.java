class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> e) {
      HashMap<Integer,Integer> freq = new HashMap();
      for(int i = 0;i < e.size();i++){
        List<Integer> ls = e.get(i);
        freq.put(ls.get(1),1);
      }
      List<Integer> ls = new ArrayList<>();
      for(int i = 0;i < e.size();i++){
       List<Integer> sl = e.get(i);  
       if(!freq.containsKey(sl.get(0))) {
        freq.put(sl.get(0),1);
        ls.add(sl.get(0));    
       }
       }
      return ls;
    }
}