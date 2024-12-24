class Solution {
    public String reorganizeString(String s) {
        StringBuilder sb = new StringBuilder();
        int[] freqarray = new int[26];
        for(int i = 0;i < s.length();i++) freqarray[s.charAt(i) - 97] += 1;
        int gidx = 1;
        int localidx = 1;
        while(sb.length() < s.length()){
            char maxchar = ' ';
            int maxfreq = 0;
            for(int i = 0;i < freqarray.length;i++) {
                if(freqarray[i] <= maxfreq) continue;
                else {
                    maxchar = (char)(97+i);
                    maxfreq = freqarray[i];
                }
            }
            freqarray[maxchar-97] = 0;
            if(sb.length() == 0)  for(int i = 0;i < maxfreq;i++) sb.append(String.valueOf(maxchar)); 
            else {
    
               for(int i = 0;i < maxfreq;i++){
                System.out.print(sb+"  "+localidx+"\n");
                 if(localidx < sb.length())sb.insert(localidx,String.valueOf(maxchar));
                 else  sb.append(String.valueOf(maxchar)); 
                 if(localidx >= sb.length()-1)  localidx = ++gidx;
                 else localidx += gidx+1;
               }
            }
        }
        for(int i = 0;i < sb.length()-1;i++) if(sb.charAt(i) == sb.charAt(i+1)) return "";
        return sb.toString();
    }
}