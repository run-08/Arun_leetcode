class Solution {
    public int findContentChildren(int[] players, int[] trainers) {   
        Arrays.sort(players);
        Arrays.sort(trainers);
        int count = 0;
        int idx = trainers.length-1;
        for(int i = players.length-1;idx >= 0 && i >= 0;i--){
            if(players[i] <= trainers[idx]) {
                count++;
                idx--;
            }
        }
        return count;
    }
}