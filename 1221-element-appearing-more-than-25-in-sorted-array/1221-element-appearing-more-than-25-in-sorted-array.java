class Solution {
    public int findSpecialInteger(int[] arr) {
        HashMap<Integer , Integer> hm = new HashMap<>();
        for(int val : arr) hm.put(val , hm.getOrDefault(val , 0)+1);
        for(int val : arr) if(((double) hm.get(val) / arr.length ) *  100  >  25.00 ) return  val;
        return -1;
    }
}