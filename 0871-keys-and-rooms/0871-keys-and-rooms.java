class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
       HashSet<Integer> hs = new HashSet<Integer>();
       dfs(rooms , 0 , hs);
       return hs.size() == rooms.size();
    }
    public void dfs(List<List<Integer>> r , int node, HashSet<Integer> hs){
        if(hs.contains(node)) return ;
        hs.add(node);
        for(int neighbournode : r.get(node)) dfs(r , neighbournode , hs);
    }
}