class Solution {
    public List<String> stringSequence(String target) {
        List<String> res = new ArrayList<>();
        String current = "";
        String Actual_data = "";
        for(char c : target.toCharArray()){
            Actual_data += String.valueOf(c);
            for(char a = 'a' ; a <= c;a++) res.add(current+String.valueOf(a));
            current = Actual_data;
        }
        return res;
    }
}