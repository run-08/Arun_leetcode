class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String,Integer> hm = new HashMap<>();
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");
        for(int i = 0;i < arr1.length;i++) hm.put(arr1[i],hm.getOrDefault(arr1[i],0)+1);
        for(int i = 0;i < arr2.length;i++) hm.put(arr2[i],hm.getOrDefault(arr2[i],0)+1);
        List<String> ls = new ArrayList<>();
        for(int i = 0;i  < arr1.length;i++) if(hm.get(arr1[i]) <= 1) ls.add(arr1[i]);
        for(int i = 0;i  < arr2.length;i++) if(hm.get(arr2[i]) <= 1) ls.add(arr2[i]);
        String res[] = new String[ls.size()];
        for(int i = 0;i < res.length;i++) res[i] = ls.get(i);
        return res;
    }
}