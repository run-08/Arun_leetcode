class Solution {
    public List<String> printVertically(String s) {
        String arr[] = s.split(" ");
        int max = 0;
        for(String Data : arr) if(Data.length() > max) max = Data.length();
         List<String> res = new ArrayList<>(); 
        for(int i = 0;i < max;i++) res.add(i,"");
        for(String Data : arr){
            int idx = 0;
            for(int i = 0;i < res.size();i++){
                String temp = res.get(i);
                if(idx >= Data.length()) res.set(i,temp+" ");
                else res.set(i,temp+Data.charAt(idx++));
            }
        }
        for(int i = 0;i < res.size();i++){
            if(res.get(i).charAt(res.get(i).length()-1) == ' '){
                StringBuffer Data = new StringBuffer(res.get(i));
                while(Data.length() > 0) {
                    if(Data.charAt(Data.length()-1) == ' ') Data.delete(Data.length()-1,Data.length());
                    else break;
                }
                res.set(i,Data.toString());
            }
        }
        return res;
    }
}