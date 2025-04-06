class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        HashMap<Integer , Integer> hm = new HashMap<>();
        int n = difficulty.length , res = 0;
        for(int i = 0;i < n;i++) hm.put(difficulty[i] , Math.max( hm.getOrDefault(difficulty[i] , 0) , profit[i]));
        Arrays.sort(difficulty);
        profit[0] = hm.get(difficulty[0]);
        for(int i = 1;i < n;i++) profit[i] = Math.max(profit[i-1] , hm.get(difficulty[i]));
        System.out.print(Arrays.toString(profit)+" "+hm);
        for(int target : worker) {
            int s = 0 , e = n - 1;
            while(s <= e) {
                int  m = s + ( e - s ) / 2;
                if(difficulty[m] == target) {
                    e = m;
                    break;
                }
                else if(difficulty[m] > target) e = m - 1;
                else s = m + 1;
            }
            if(e >= 0) res += (profit[e]);
        }
        return res;
    }
}