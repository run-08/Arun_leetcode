class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int m = 0 , g = 0 , p = 0 , pc = 0 , gc = 0 , mc = 0 , n = travel.length;
        for(int i = 1;i < n;i++) travel[i] += travel[i-1];
        n = garbage.length;
        for(int i = 0;i < n;i++) {
            String waste = garbage[i];
            boolean ism = false , isp = false , isg = false;
            for(char c : waste.toCharArray()) {
               if(c == 'M') {
                 ism = true;
                 m++;  
               }
               if(c == 'G') {
                isg = true;
                g++;
               }
               if(c == 'P') {
                isp = true;
                p++;
               }
            }
            if(i == 0) continue;
            if(isp) pc = travel[i-1];
            if(isg) gc = travel[i-1];
            if(ism) mc = travel[i-1];
        }
        return m+p+g+mc+pc+gc;
    }
}