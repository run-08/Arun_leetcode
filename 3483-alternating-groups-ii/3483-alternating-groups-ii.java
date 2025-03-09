class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int res = 0 , idx = 1 , move = 1 , n = colors.length;
        for(;idx < k;idx++){
            if(colors[idx] == colors[idx-1]) break;
            move++;
        }
         int i = idx+1;
        if(move == k) {
            idx -= 1;
            res = 1;
            i = k;
        }
        else move = 1;
        // System.out.print(idx);
        while(true){
            if(i >= n){
                move++;
                idx--;
                if(idx < 0 || colors[0] == colors[n-1]) break;
            }
            else if(colors[i] != colors[i-1]) move++;
            else move = 1;
            if(move >= k) res++;
            i++;
        }
        return res;
    }
}