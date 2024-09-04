class Solution {
    public int[][] insert(int[][] nums, int[] newm) {
        if(nums.length == 0)  return new int[][] {{newm[0],newm[1]}};
        int res[][] = new int[nums.length+1][2];
        boolean isArrived = false;
			for(int i = 0;i < nums.length;i++) {
				if(nums[i][0] < newm[0]) res[i] = nums[i];
				else {
					res[i] = newm;
					while(i < nums.length) res[i+1] = nums[i++];
                    isArrived = true;
				}
			}
            if(!isArrived) res[res.length-1] = new int[] {newm[0],newm[1]};
            int first = res[0][0];
            int max = res[0][1];
            List<int[]> ls = new ArrayList<>(); 
            for(int i = 1;i < res.length;i++){
                if(res[i][0] <= max){
                     if(max < res[i][1]) max = res[i][1];
                }
                else{
                    ls.add(new int[]{first,max});
                    first = res[i][0];
                    max = res[i][1];
                }
            }
            ls.add(new int[]{first,max});
            int result[][] = new int[ls.size()][2];
            int i = 0;
           while(ls.size() > 0) result[i++] = ls.remove(0);
            return result;
    }
}