class Solution {
    int[][] dp;
    int n;
    public int minimumDeletions(String s) {
       this.n = s.length();
       dp = new int[n+1][2];
       for(int i=0;i<=n;i++) Arrays.fill(dp[i],-1);
       return helper(s,0,false);
    }
    private int helper(String s,int idx, boolean flag){
       if(idx==n) return 0;
       int col = (flag ? 1 : 0);
       if(dp[idx][col] != -1) return dp[idx][col];
       int min = Integer.MAX_VALUE / 2;
    //    if flag, then it is b....
       if(flag){
           if(s.charAt(idx)=='b'){
                // then continue with b...
                min = Math.min(min,helper(s,idx+1,flag));
           }
        //    then chnge current element to b...
           else min = Math.min(min,1+helper(s,idx+1,true));
       }
       else{
        // Check if it is a...
        if(s.charAt(idx)=='b'){
            // just maintain with b....
            min = Math.min(min,helper(s,idx+1,true));
            min = Math.min(min,helper(s,idx+1,false)+1);
        }
        else {
            // if it is a....then just continue.....
            min = Math.min(min,helper(s,idx+1,false)); 
        }
       }
       return dp[idx][col] = min;
    }
}