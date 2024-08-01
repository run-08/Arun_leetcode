class Solution {
    public int countSeniors(String[] details) {
        int res = 0;
      for(String val : details){
         String temp = String.valueOf(val.charAt(11));
         temp += String.valueOf(val.charAt(12));
         System.out.print(temp);
          int value = Integer.parseInt(temp);
          if(value > 60)res++;
      }
      return res;
    }
}