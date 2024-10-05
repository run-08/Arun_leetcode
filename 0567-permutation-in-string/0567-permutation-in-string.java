class Solution {
    public boolean checkInclusion(String s1, String s2) {
       if(s1.length() > s2.length()) return false; 
        char arr[] = s1.toCharArray();
        Arrays.sort(arr);
        s1 = new String(arr);
        StringBuffer data = new StringBuffer();
        for(int i = 0;i < s2.length();i++){
            data.append(String.valueOf(s2.charAt(i)));
            if(data.length() == s1.length()){
                //System.out.print(data+" ");
               char temp[] = data.toString().toCharArray();
                Arrays.sort(temp);
                StringBuffer sb =new StringBuffer(new String(temp));
                if(s1.equals(sb.toString())) return true;
                data.delete(0,1);
                }
           // data.delete(0,1);
            }
        return false;
    }
}