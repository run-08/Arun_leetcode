class Solution {
    public String sortSentence(String s) {
        String arr[] = s.split(" ");
        Arrays.sort(arr , (a,b) -> Character.compare(a.charAt(a.length()-1),b.charAt(b.length()-1)));
        s =  "";
        for(String val : arr){
            s += val.substring(0,val.length()-1)+" ";
        }
        return s.substring(0,s.length()-1);
    }
}