class Solution {
    HashMap<Integer , Integer> hm;
    public int minimumCardPickup(int[] cards) {
        hm = new HashMap<>();
        int min = Integer.MAX_VALUE , n = cards.length;
        for(int i = 0;i < n;i++) {
            if(hm.containsKey(cards[i])) min = Math.min((i-hm.get(cards[i])+1) , min);
            hm.put(cards[i] , i);
        }
        return (min != Integer.MAX_VALUE) ? min : -1;
    }
}