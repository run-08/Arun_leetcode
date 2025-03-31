class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int max = 0 , n = s.length() , unique = 0;
        int[] arr = new int[26];
        HashMap<String , Integer> hm = new HashMap<>();
        String temp = "";
        for(int i = 0;i < minSize-1;i++){
             temp += s.charAt(i);
             arr[s.charAt(i)-97]++;
             if(arr[s.charAt(i)-97] == 1) unique++;
        }
        for(int i = minSize-1;i < n;i++) {
             temp += s.charAt(i);
            arr[s.charAt(i)-97]+=1;
            if(arr[s.charAt(i)-97] == 1) unique++;
            // System.out.print(unique+" "+temp+" ");
            hm.put(temp , hm.getOrDefault(temp , 0)+1);
            if(unique <= maxLetters)max = Math.max(hm.get(temp) , max); 
            arr[temp.charAt(0)-97]-= 1;
            if(arr[temp.charAt(0)-97] == 0) unique--;
            temp = temp.substring(1,minSize);
        }
        return max;
    }
}