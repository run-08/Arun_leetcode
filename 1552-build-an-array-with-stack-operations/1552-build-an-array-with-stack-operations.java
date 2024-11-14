class Solution {
    public List<String> buildArray(int[] target, int n) {
        int idx = 1;
        List<String> res = new ArrayList<>();
       for(int i = 0;i < target.length;i++){
          res.add("Push");
          if(target[i] != (idx++)) {
            res.add("Pop");
            i--;
          }
       }
        return res;
    }
}