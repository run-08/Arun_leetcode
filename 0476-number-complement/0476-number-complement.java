class Solution {
    public int findComplement(int n) {
         if(n <=1){
              return 0;
        }
      if(n == 2){
        return 1;
      }
         StringBuffer value = new StringBuffer();
         if(n <= 1){
             System.out.println("The Value is an 0");
         }
         while(!(n <= 0)){
             value.append(n % 2);
             n = n/2;
             if(n == 1){
                 value.append(n);
                 break;
             }
         }
         StringBuffer res = new StringBuffer();
         for(int i = (value.length())-1;i >= 0;i--){
             if(value.charAt(i) == '0'){
                 res.append('1');
             }
             else{
                 res.append('0');
             }
         }
        int result = 0;
        int count = 0;
         for(int i = (res.length())-1;i >= 0;i--){
             int data = Character.getNumericValue(res.charAt(i));
            if(data == 0){
                count++;
                continue;
            }
            else{
               result += data*Math.pow(2,count++);
            }
         }
        return result;
    }
}