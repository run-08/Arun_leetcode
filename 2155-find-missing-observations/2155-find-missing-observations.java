class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
     int sum = 0;
     for( int val : rolls) sum += val;
     int target = (mean*(rolls.length+n) - sum);
     if(mean > ((sum)+n*6)/(n+rolls.length) || (sum > mean*(n+rolls.length) || target < n))  return new int[]{};
     int res[] = new int[n];
     int bal = ((target)/n)*(n);
     for(int  i = 0;i < n;i++) res[i] = target/n;
     if(bal == target) return res;
     bal = target - bal;
     int carry = 0;
     for(int i = 0;i < res.length;i++){
        carry = 6 - res[i];
        if(carry > bal){
            res[i] += bal;
            return res;
        }
        res[i] += carry;
        bal -= carry;
     }
     return res;
    }
}