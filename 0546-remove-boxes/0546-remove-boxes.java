class Solution {
    HashMap<String,Integer> memo;
    public int removeBoxes(int[] boxes) {
        memo = new HashMap<>();
        return dfs(0,boxes.length-1,0,boxes);
    }

    private int dfs(int l,int r,int k,int[] arr){
        if(l > r) return 0;
        String key = l+","+r+","+k;
        if(memo.containsKey(key)) return memo.get(key);
        while (l+1 <= r && arr[l] == arr[l+1]) {
            l++;
            k++;
        } 
        // not comparing, just picking current
        int result = (k+1)*(k+1)+dfs(l+1,r,0,arr);
        for(int i=l+1;i<=r;i++){
            // just see, the matches 
              if(arr[i]==arr[l]) result=Math.max(
                result,
                dfs(l+1,i-1,0,arr)+dfs(i,r,k+1,arr)
              );
        }
        memo.put(key,result);
        return result;
    }

    // private int dfs(int idx,int[] arr){
    //     if(idx >= arr.length) return 0;
    //     int[] tempArr = Arrays.copyOf(arr,arr.length);
    //     String key = Arrays.toString(arr)+"-"+idx;
    //     if(memo.containsKey(key)) return memo.get(key);
    //     int max=0,prev=-1,cnt=0;
    //     max=Math.max(dfs(idx+1,arr),max);
    //     for(int i=idx;i>=0;i--){
    //        if(arr[i]==101) continue;
    //         tempArr[i]=101;
    //         int[] newArr = Arrays.copyOf(tempArr,tempArr.length);
    //         if(prev==arr[i]) {
    //          newArr[i]=101;
    //          cnt++;
    //          max= Math.max( cnt * cnt + dfs(idx+1,newArr),max );
    //        }
    //        else{
    //          newArr[i]=101;
    //          prev=arr[i];
    //          cnt=1;
    //          max=Math.max(1+dfs(idx+1,newArr),max);
    //        }
    //     }
    //     memo.put(key,max);
    //     return max;
    // }

    // TLE at 20
}