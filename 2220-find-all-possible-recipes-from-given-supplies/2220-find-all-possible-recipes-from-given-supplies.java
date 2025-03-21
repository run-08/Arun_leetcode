class Solution {
    List<String> sup ;
    List<String> rec;
    HashMap<String , List<String>> hm = new HashMap<>();
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        sup = new ArrayList<>();
        rec = new ArrayList<>();
        int n = recipes.length;
        List<String> res = new ArrayList<>();
        for(int i = 0;i < n;i++){
             rec.add(recipes[i]);
             hm.put(recipes[i] , ingredients.get(i));
        }
        for(String Data : supplies) sup.add(Data);
        for(String Data : recipes) {
            if(res.contains(Data)) continue;
            if(isMake(Data , new HashSet<>())   ) res.add(Data);
        }
        return res;
    }
    public boolean isMake(String recipe , HashSet<String> hs) {
        List<String> ing = hm.get(recipe);
        for(String Item : ing) {
            if(hs.contains(Item)) return false;
           if(sup.contains(Item)) continue;
           else if(rec.contains(Item)){
             hs.add(Item);
             if(!isMake(Item , hs)) return false;
             else  sup.add(Item);
             hs.remove(Item);
           }
           else return false;
        }
        return true;
    }
}