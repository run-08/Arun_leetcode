class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Integer , Integer> hm = new HashMap<>();
        HashMap<Integer , Integer> hm1 = new HashMap<>();
        for(char c : guess.toCharArray()) hm1.put(Character.getNumericValue(c) , hm1.getOrDefault(Character.getNumericValue(c),0)+1);
        for(char c : secret.toCharArray()) hm.put(Character.getNumericValue(c) , hm.getOrDefault(Character.getNumericValue(c),0)+1);
        int res = 0;
        for(int i = 0;i < secret.length();i++) if(secret.charAt(i) == guess.charAt(i)) res++;
        int same_freq = 0;
        for(int i = 0;i <= 9;i++)  same_freq += (hm.containsKey(i) && hm1.containsKey(i)) ? ((hm.get(i) <= hm1.get(i)) ? hm.get(i): hm1.get(i))  : 0;
        return res+"A"+(same_freq-res)+"B";
    }
}