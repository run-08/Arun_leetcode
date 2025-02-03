class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        String temp = "";
        if(n <= 10) return new ArrayList<>();
        HashMap<String , Integer> hm = new HashMap<>();
        List<String> ls = new ArrayList<>();
        for(int i = 0;i < 10;i++) temp += s.charAt(i);
        hm.put(temp , 1);
        for(int i = 10;i < n;i++) {
            temp = temp.substring(1);
            temp += s.charAt(i);
            int freq = hm.getOrDefault(temp,0);
            hm.put(temp , freq+1);
            if(freq+1 == 2) ls.add(temp); // checking if perfectly 2 , for sometimes it will more trhan one appears
        }
        return ls;
    }
}