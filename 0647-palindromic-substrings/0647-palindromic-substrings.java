class Solution {
    public int countSubstrings(String s) {
        int ans = 0 , n = s.length();
        for(int i = 0;i < n;i++) {
            ans++;
            String res  = ""+s.charAt(i);
            for(int j  = i+1;j < n;j++) {
                res += s.charAt(j);
                int m = res.length();
                boolean isPalindrome = true;
                for(int k = 0;k < m/2 && isPalindrome;k++) {
                    if(res.charAt(k) != res.charAt(m-k-1)) isPalindrome = false;
                }
                // System.out.print(res+"\n");
                if(isPalindrome) ans++;
            }
        }
        return  ans;
    }
}