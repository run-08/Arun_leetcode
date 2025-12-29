class Solution {
    HashMap<String , List<Character> > map;
    HashMap<String,Boolean> memo;
    public boolean pyramidTransition(String bottom, List<String> allowed) {
          map = new HashMap<>();
          memo = new HashMap<>();
          for(String block : allowed) {
              String key = block.charAt(0)+""+block.charAt(1);
              map.computeIfAbsent( key , k -> new ArrayList<>()).add(block.charAt(2)); 
           }
          return dfs(bottom , "" , 0);
    }
    private boolean dfs(String bottomLayer , String currentLayer , int index){
        String key = bottomLayer+" "+currentLayer;
        if(memo.containsKey(key)) return memo.get(key);
        if(bottomLayer.length() == 2) return map.getOrDefault( bottomLayer , new ArrayList<>()).size() != 0;
        int bottomLayerSize = bottomLayer.length();
         if(index == bottomLayerSize-1) return (dfs(currentLayer , "" , 0)) ;
        List<Character> colors = map.getOrDefault(bottomLayer.charAt(index)+""+bottomLayer.charAt(index+1) , new ArrayList<>());
        for(char color : colors){
             if(dfs(bottomLayer , currentLayer+color , index+1)) {
                memo.put(key,true);
                return true;
             }
        }
        memo.put(key,false);
        return false;
    }
}