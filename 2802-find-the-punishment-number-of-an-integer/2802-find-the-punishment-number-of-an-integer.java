class Solution {
    public int punishmentNumber(int n) {
            int res1 = 0;
	        for(int i = 1;i <= n;i++) {
	            String ele = String.valueOf(i*i);
	            if(bacres(i , ele , 0 , ele.length()-1)) res1 += i*i;
	        }
	        return res1;
	    }
	    static public boolean bacres(int val ,String s1 ,int carry , int idx ) {
	    	if(idx == -1 && s1.length() > 0) return false;
	    	if(idx == -1 ) return (carry) == val;
	    	return bacres(val , s1.substring(0,idx) , carry+Integer.parseInt(s1.substring(idx)) , idx-1) || bacres( val , s1 , carry , idx-1 );
	    }
}