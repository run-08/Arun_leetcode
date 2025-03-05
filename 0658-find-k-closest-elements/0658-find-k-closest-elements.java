class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Deque<Integer> ls = new ArrayDeque<>();
        for(int i= 0;i < k;i++) ls.add(arr[i]);
        int n = arr.length;
        for(int i  = k;i < n;i++){
            int start = ls.peek();
            if((Math.abs(start - x) > Math.abs(arr[i] - x))){
                ls.removeFirst();
                ls.add(arr[i]);
            }
        }
        return new ArrayList<>(ls);
    }
}