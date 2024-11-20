class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> res = new ArrayList<>();
        for(String word : words){
            String data = "";
            for(char c : word.toCharArray()){
                 if(c != separator) data += String.valueOf(c);
                 else {
                    if(data == "")continue;
                     res.add(data);
                     data = "";
                 }
            }
            if(data!= "") res.add(data);
        }
        return res;
    }
}