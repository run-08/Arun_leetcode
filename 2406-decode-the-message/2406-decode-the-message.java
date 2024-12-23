class Solution {
    public String decodeMessage(String key, String message) {
        char chararray[] = new char[26];
        int idx = 0;
        for(char c : key.toCharArray())if(c != ' '  && (chararray[c-97] == 0)) chararray[c-97] = (char)(97+idx++);
        String response = "";
        for(char c : message.toCharArray()) response += (c >= 97 && c <= 123) ? String.valueOf(chararray[c-97]) : " ";
        return response;
    }
}