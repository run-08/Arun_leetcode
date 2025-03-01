class Solution {
    public int[] applyOperations(int[] arr) {
        int n = arr.length;
        for(int i =  0;i < n-1;i++) {
            if(arr[i] == arr[i+1]) {
                arr[i] *= 2;
                arr[i+1] = 0;
            }
        }
        int idx = 0;
        int cnt = 0;
        for(int i = 0;i < n;i++) {
            if(arr[i] == 0) cnt++;
            else arr[idx++] = arr[i];
        }
        for(int i = n-1;cnt != 0;i--){
            cnt--;
            arr[i] = 0;
        }
        return arr;

    }
}