class Solution {
    public int numSub(String s) {
        long ans=0, cnt=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='0'){
                ans =  ans+(cnt*(cnt+1)/2);
                cnt=0;
            }
            else cnt++;
        }
        ans = ans+(cnt*(cnt+1)/2);
        return (int)(ans % 1000000007);
    }
}