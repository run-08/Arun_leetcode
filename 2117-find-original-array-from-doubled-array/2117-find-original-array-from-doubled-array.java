class Solution {
    public int[] findOriginalArray(int[] changed) {
        HashMap<Integer , Integer> hm = new HashMap<>();
        int n = changed.length;
        if((n & 1) == 1) return new int[]{};
        for(int i = 0;i < n;i++)hm.put(changed[i] , hm.getOrDefault(changed[i] , 0)+1);
        int[] arr = new int[n/2];
        int idx = 0;
        Arrays.sort(changed);
        for(int ele : changed) {
             int target = ele * 2;
             if(target == 0 && hm.containsKey(0)){
                if(hm.get(0) % 2 != 0) return new int[]{};
                int freq = hm.get(0);
                for(int i = 0;i < freq;i+=2) arr[idx++] = 0;
                hm.remove(0);
                continue;
             }
             if(hm.containsKey(ele) && hm.containsKey(target) ) {
                while(hm.get(ele) > 0 && hm.get(target) > 0) {
                    arr[idx++] = ele;
                    hm.put(ele , hm.get(ele)-1);
                    hm.put(target , hm.get(target)-1);
                }
             }
        }
        return idx == n/2 ?  arr : new int[]{};
    }
}