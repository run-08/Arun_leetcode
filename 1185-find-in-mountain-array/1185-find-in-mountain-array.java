/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray m) {
        int length = m.length()-1;
        if(length+1 < 3)return -1;
        int pivot= 0;
        int s = 0;
        int e = length;
      while(s < e){
          int mid = (s+e)/2;
          if(m.get(mid+1) < m.get(mid)) e = mid;
          else s = mid+1;    
          }
         pivot = s;
        if(m.get(pivot) == target)return pivot;
        s = 0;
        e = pivot-1;
       while(s <= e){

           int mid = (s+e)/2;

           int data = m.get(mid);

           if(data == target) return mid;

           if(data < target)s = mid+1;

           else e = mid-1;

           }
        s = pivot+1;
        e = length;
       while(s <= e){
           int mid = (s+e)/2;
           int data = m.get(mid);
           if(data == target) return mid;
           if(data > target)s = mid+1;
           else e = mid-1;
           }   
           return -1;
    }
}