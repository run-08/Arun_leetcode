class Solution {
    public String replaceWords(List<String> d, String sentence) {
        HashMap<Character,List<String>> hm = new HashMap<>();
        for(int i = 0;i < d.size();i++){
            if(hm.containsKey(d.get(i).charAt(0))){
                List<String> ls = hm.get(d.get(i).charAt(0));
                ls.add(d.get(i));
                hm.put(d.get(i).charAt(0),new ArrayList<>(ls));
            }
            else{
                List<String> ls = new ArrayList<>();
                 ls.add(d.get(i));
                hm.put(d.get(i).charAt(0),new ArrayList<>(ls));
            }
        }
        String arr[] = sentence.split(" ");
        String result = "";
         for(String Data : arr){
             if(hm.containsKey(Data.charAt(0))){
                  List<String> ls = hm.get(Data.charAt(0));
                  result += findShortestWord(ls,Data)+" ";
             }
             else result += Data+" ";
        }
        StringBuilder sb = new StringBuilder(result);
        sb.delete(sb.length()-1,sb.length());
       return sb.toString();
}
    public String findShortestWord(List<String> ls , String Data){
            int shortNumber = Integer.MAX_VALUE;
            String word = "";
            for(int i = 0;i < ls.size();i++){
                if(ls.get(i).length() > Data.length()) continue;
                if(ls.get(i).equals(Data.substring(0,ls.get(i).length()))) {
                    String value = ls.get(i);
                    if(shortNumber > value.length()){
                        shortNumber =  value.length();
                        word = value;
                    }
                }
            }
            return (word.equals("")) ? Data : word;
    }
}