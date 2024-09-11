class Solution {
    public int minBitFlips(int start, int goal) {
       int count = 0;
       StringBuffer sb = new StringBuffer();
       StringBuffer sb1 = new StringBuffer();
       while(start != 0){
         sb.insert(0,String.valueOf(start % 2));
         start /= 2;
       } 
       while(goal != 0){
        sb1.insert(0,String.valueOf(goal % 2));
        goal /= 2;
       }
       while(sb.length() != sb1.length()){
        if(sb.length() < sb1.length()) sb.insert(0,"0");
        else sb1.insert(0,"0");
       }
       for(int i = 0;i < sb.length();i++)  if(sb.charAt(i) != sb1.charAt(i)) count++;
       return count; 
    }
}
