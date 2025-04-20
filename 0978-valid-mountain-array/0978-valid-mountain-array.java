class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if(n<3){
            return false;
        }
        int i = 0;
        for(;i<n-1;i++){
            if(arr[i]==arr[i+1]){
                return false;
            }
            if(arr[i]>arr[i+1]){
                break;
            }
        }
        if(i==0 || i==n-1){
            return false;
        }
        for(;i<n-1;i++){
            if(arr[i]==arr[i+1]){
                return false;
            }
            if(arr[i]<arr[i+1]){
                return false;
            }
        }
        return true;
    }
}