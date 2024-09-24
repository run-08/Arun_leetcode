class Solution {
    public boolean validMountainArray(int[] arr) {
       if(arr.length < 3) return false;
       for(int i = 0;i < arr.length-1;i++){
        if(arr[i] == arr[i+1]) return false;
        if(arr[i] > arr[i+1])return  compute(i,arr);
        if(i == arr.length-2) return false;
       } 
       return true;
    }
    public boolean compute(int index,int[] arr){
        if(index == 0) return false;
        for(int i = index;i < arr.length-1;i++) {
            if(arr[i] == arr[i+1]) return false;
             if(arr[i] < arr[i+1])  return false;
        }
         return true;
    }
}