class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String,Integer> hm = new HashMap<String,Integer>();
        for(String val : arr) hm.put(val,hm.getOrDefault(val,0)+1);
        for(int i  = 0;i < arr.length;i++)  if((int)hm.get(arr[i]) == 1 && --k == 0) return arr[i];
        return "";
    }
}