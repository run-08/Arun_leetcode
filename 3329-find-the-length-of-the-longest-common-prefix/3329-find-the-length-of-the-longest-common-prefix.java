class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> hs = new HashSet<>();
        for(int val : arr1){
            StringBuffer Data = new StringBuffer(String.valueOf(val));
            while(Data.length() > 0) {
                hs.add(Data.toString());
                Data.delete(Data.length()-1,Data.length());
            }
        }
        int max = 0;
        for(int val : arr2) {
            StringBuffer Data = new StringBuffer(String.valueOf(val));
            while(Data.length() > 0){
                if(hs.contains(Data.toString())) if(max < Data.length()) max = Data.length();
                Data.delete(Data.length()-1,Data.length());
            }
        }
        return max;
    }
}