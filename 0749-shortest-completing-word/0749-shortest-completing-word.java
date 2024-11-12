class Solution {
    public String shortestCompletingWord(String l, String[] words) {
        int min = Integer.MAX_VALUE;
        l = l.toLowerCase();
        
        String res = "";
        HashMap<Character , Integer> hm = new HashMap<>();
        for(char c : l.toCharArray()) hm.put(c , hm.getOrDefault(c,0)+1);
        for(String data : words){
             data = data.toLowerCase();
             HashMap<Character , Integer> in_hm = new HashMap<>();
            for(char c : data.toCharArray()) in_hm.put(c , in_hm.getOrDefault(c,0)+1);
            // System.out.print(in_hm+"\n");
            for(int i = 0;i < l.length()+1;i++){
                 if(i == l.length()){
                     if(min > data.length()){
                         min = data.length();
                         res = data;
                     }
                     break;
                 }
                 if(l.charAt(i) == ' ' || l.charAt(i) == '1' || l.charAt(i) == '2' || l.charAt(i) == '3'|| l.charAt(i) == '4'|| l.charAt(i) == '5'|| l.charAt(i) == '6'|| l.charAt(i) == '7'|| l.charAt(i) == '8'|| l.charAt(i) == '9' || l.charAt(i) == '0') continue;
                if(!in_hm.containsKey(l.charAt(i)) || in_hm.get(l.charAt(i)) < hm.get(l.charAt(i))) break;
                
             }
                    }
        return res;
    }
}