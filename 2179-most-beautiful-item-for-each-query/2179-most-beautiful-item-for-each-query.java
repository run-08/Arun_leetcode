class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = items.length , idx = 0;
        HashMap<Integer , Integer> hm = new HashMap<>();
        List<Integer> ls = new ArrayList<>();
        for(int i = 0;i < n;i++) {
           ls.add(items[i][0]);
           int max = Math.max(hm.getOrDefault(items[i][0] , 0) , items[i][1]);
           hm.put(items[i][0] , max);
        }
        Collections.sort(ls);
        n = queries.length;
        int[] res = new int[n];
        n = ls.size();
        int max = 0;
        List<Integer> p_sum = new ArrayList<>();
        for(int val : ls) {
            int ele = hm.get(val);
           max =  Math.max(ele , max);
           p_sum.add(max);
        }
        for(int target : queries) {
            int start = 0;
            int end = n-1;
            while(start <= end) {
                int mid = start + ( end - start ) / 2;
                int val = ls.get(mid);
                if(val == target) {
                    end = mid;
                    break;
                }
                else if(val > target) end = mid -1;
                else start = mid+1;
            }
            res[idx++] = (end >= 0 && end < n) ? p_sum.get(end) : 0;
        }
        return res;
    }
}