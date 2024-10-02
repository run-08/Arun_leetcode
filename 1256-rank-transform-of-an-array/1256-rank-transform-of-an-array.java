class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int res[] = new int[arr.length];
        for(int i = 0;i < arr.length;i++) res[i] = arr[i];
        Arrays.sort(arr);
        HashMap<Integer,Integer> hm = new HashMap<>();
        int rank = 1;
        for(int val : arr) if(!hm.containsKey(val)) hm.put(val,rank++);
        for(int i = 0;i < res.length;i++) res[i] = hm.get(res[i]);
        return res;
    }
}