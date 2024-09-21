class Solution {
    public List<Integer> lexicalOrder(int n) {
       Integer[] arr = new Integer[n];
      for(int i = 0;i < n;i++) arr[i] = i+1;
      Arrays.sort(arr, (a, b) -> String.valueOf(a).compareTo(String.valueOf(b)));
      List<Integer> res = new ArrayList<>();
      for(int num : arr) res.add(num);
      return res;
    }
}