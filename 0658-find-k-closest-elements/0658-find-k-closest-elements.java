class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ls = new ArrayList<>();
        for(int i= 0;i < k;i++) ls.add(arr[i]);
        int n = arr.length;
        for(int i  = k;i < n;i++){
            int start = ls.get(0);
            if((Math.abs(start - x) > Math.abs(arr[i] - x))){
                ls.remove(0);
                ls.add(arr[i]);
            }
        }
        return ls;
    }
}