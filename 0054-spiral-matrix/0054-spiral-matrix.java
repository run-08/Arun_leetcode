class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        left(matrix , 0 , matrix.length-1 , 0 , matrix[0].length-1, res);
        return res;
    }
    public void left (int[][]arr , int t , int b , int lc , int rc , List<Integer> ls) {
		   if(t > b || rc < lc ) return;
		    for(int  i =  lc;i <= rc;i++) ls.add(arr[t][i]);
			t++;
			down(arr , t , b , lc , rc , ls);
	}
	 public void down(int[][] arr , int t , int b , int lc , int rc , List<Integer> ls) {
		if(t > b || rc < lc ) return;
		for(int i = t;i <= b;i++) ls.add(arr[i][rc]);
		rc--;
		right(arr , t , b , lc , rc , ls);
	}
    public void right(int[][] arr , int t , int b , int lc , int rc , List<Integer> ls) {
		if(t > b || rc < lc ) return;
		for(int i = rc;i >= lc;i--) ls.add(arr[b][i]);
		 b--;
		 top(arr , t , b , lc , rc , ls);
	}
	 public void top(int[][] arr , int t , int b , int lc , int rc , List<Integer> ls) {
		if(t > b || rc < lc ) return;
		for(int i = b;i >= t;i--) ls.add(arr[i][lc]);
		lc++;
		left(arr , t , b , lc , rc , ls);
	}
}