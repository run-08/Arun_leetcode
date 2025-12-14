class Solution {
     Boolean[][] isPalindrome;
    public String longestPalindrome(String s) {
        int n = s.length(),max=0,start=0,end=0;
        isPalindrome = new Boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome[i][j]=isPalindrome(s,i,j)) {
                    if(max < j-i){
                        max=j-i;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }
    private boolean isPalindrome(String s, int i, int j){
        if(i>=j) return isPalindrome[i][j]=true;
        if(isPalindrome[i][j] != null) return isPalindrome[i][j];
        if(s.charAt(i)!=s.charAt(j)) return isPalindrome[i][j] = false;
        return isPalindrome[i][j] = isPalindrome(s,i+1,j-1);
    }
}