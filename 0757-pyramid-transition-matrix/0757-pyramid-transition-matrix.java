class Solution {
    HashMap<String , List<Character> > map;
    public boolean pyramidTransition(String bottom, List<String> allowed) {
          map = new HashMap<>();
          for(String block : allowed) {
              String key = block.charAt(0)+""+block.charAt(1);
              map.computeIfAbsent( key , k -> new ArrayList<>()).add(block.charAt(2)); 
           }
          return dfs(bottom , "" , 0);
    }
    private boolean dfs(String bottomLayer , String currentLayer , int index){
        if(bottomLayer.length() == 2) return map.getOrDefault( bottomLayer , new ArrayList<>()).size() != 0;
        int bottomLayerSize = bottomLayer.length();
         if(index == bottomLayerSize-1) return (dfs(currentLayer , "" , 0)) ;
        List<Character> colors = map.getOrDefault(bottomLayer.charAt(index)+""+bottomLayer.charAt(index+1) , new ArrayList<>());
        for(char color : colors){
             if(dfs(bottomLayer , currentLayer+color , index+1)) return true;
        }
        return false;
    }
}