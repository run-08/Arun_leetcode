class Solution {
    public int numberOfSubarrays(int[] arr, int k) {
        int  cnt = 0 , zero_idx = -1;
        int n = arr.length;
        int i = 0;
        for(;i < n && k > 0;i++){
            if(arr[i] % 2 == 0 && zero_idx == -1) cnt++;
            else if(arr[i] % 2 == 1 && zero_idx == -1) {
                cnt++;
                zero_idx = i;
                k--;
            }
            else if(arr[i] % 2 != 0) k--;
        }
        if(zero_idx == -1)  return 0;
        if(k != 0) return 0;
        int nice_sub = cnt;
        for(;i < n;i++){
            if(arr[i] % 2 == 0) nice_sub += cnt;
            else {
                cnt = 1;
                for(;zero_idx+1 < n;zero_idx++){
                    if(arr[zero_idx+1] % 2 == 0) cnt++;
                    else {
                        zero_idx++;
                        break;
                    }
                }
                nice_sub += cnt;
                System.out.print(cnt);
            }
        }
        return nice_sub;
    }
}