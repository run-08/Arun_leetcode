class Solution {
    public int longestPalindromeSubseq(String Data1) {
        String Data2 = new StringBuilder(Data1).reverse().toString();
        Integer dp[][] = new Integer[Data1.length()][Data2.length()];
        return (isPalindrome(Data1,Data2,Data1.length()-1, Data2.length()-1 , dp));
	}
	static public int isPalindrome(String s1 , String s2 , int idx1 , int idx2 , Integer[][] dp) {
		if(idx1 < 0 || idx2 < 0) return 0;
		if(dp[idx1][idx2] != null) return dp[idx1][idx2];
		if(s1.charAt(idx1) == s2.charAt(idx2)) dp[idx1][idx2] = 1 + isPalindrome(s1 , s2 , idx1 -1 , idx2 - 1 , dp);
		else dp[idx1][idx2] =  Math.max(isPalindrome(s1  , s2 , idx1 - 1, idx2 , dp),isPalindrome(s1,s2 , idx1 , idx2- 1 , dp));
		return dp[idx1][idx2];
	}
}