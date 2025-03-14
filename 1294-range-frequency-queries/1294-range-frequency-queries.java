class RangeFreqQuery {
     HashMap<Integer , List<Integer>> hm = new HashMap<>();
    public RangeFreqQuery(int[] arr) {
       int n = arr.length;
       for(int i = 0;i < n;i++) {
         hm.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
       }
    }
    public int query(int left, int right, int value) {
        if(!hm.containsKey(value)) return 0;
        List<Integer> ls = hm.getOrDefault(value , new ArrayList<>());
        int l = -1, r = -1 , s = 0 , e = ls.size()-1;
        while(s <= e){
            int mid = s + ( e - s) / 2;
            if(ls.get(mid) == left) {
                l = mid;
                break;
            }
            else if(ls.get(mid) < left) s = mid+1;
            else e = mid-1;
        }
        if(l == -1) l = s;
        s = 0;
        e = ls.size()-1;
         while(s <= e){
            int mid = s + ( e - s) / 2;
            if(ls.get(mid) == right) {
                r = mid;
                break;
            }
            else if(ls.get(mid) < right) s = mid+1;
            else e = mid-1;
        }
        if(r == -1) r = e;
        return (r-l)+1;
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */