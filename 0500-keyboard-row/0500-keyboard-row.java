class Solution {
     String one = "qwertyuiopQWERTYUIOP";
        String two = "asdfghjklASDFGHJKL";
        String three = "zxcvbnmZXCVBNM";
    public String[] findWords(String[] words) {
        List<String> ls = new ArrayList<>();
        for(String val : words) if(compute(val)) ls.add(val);
        String arr[] = new String[ls.size()];
        for(int i = 0;i < ls.size();i++) arr[i] = ls.get(i);
        return arr;
    }
    public boolean compute(String word){
        if(one.contains(String.valueOf(word.charAt(0))))  for(char c : word.toCharArray())  if(!one.contains(String.valueOf(c))) return false;
        if(two.contains(String.valueOf(word.charAt(0))))  for(char c : word.toCharArray())  if(!two.contains(String.valueOf(c))) return false;
        if(three.contains(String.valueOf(word.charAt(0))))  for(char c : word.toCharArray())  if(!three.contains(String.valueOf(c))) return false;
        return true;
    }
}