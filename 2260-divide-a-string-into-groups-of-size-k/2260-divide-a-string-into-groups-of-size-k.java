class Solution {
    public String[] divideString(String s, int k, char fill) {
        String arr[] = new String[(s.length() / k) + ((s.length() % k == 0) ? 0 : 1)];
        int arridx = 0;
        int idx = 0;
        while(idx < s.length() ){
          if(arr[arridx] != null) arr[arridx] += String.valueOf(s.charAt(idx++));
          else arr[arridx] = String.valueOf(s.charAt(idx++));
          if(arr[arridx].length() == k) arridx++;
        }
        while(arr[arr.length-1].length() != k) arr[arr.length-1] += String.valueOf(fill);
        return arr;
    }
}