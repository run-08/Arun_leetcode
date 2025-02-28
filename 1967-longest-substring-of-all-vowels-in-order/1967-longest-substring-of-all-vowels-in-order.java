class Solution {
    public int longestBeautifulSubstring(String s) {
            int n = s.length();
            int max = 0;
            int in_max = 1;
            HashMap<Character , Integer> hm = new HashMap<>();
            hm.put('a' , 1);
            hm.put('e' , 2);
            hm.put('i' , 3);
            hm.put('o' , 4);
            hm.put('u' , 5);
            char prev = 'u';
            int i = s.indexOf("a"); 
            if(i < 0) return 0;
            else i++;
            for(;i < n;i++) {
               if(s.charAt(i) == 'u') {
            	   if( hm.get(s.charAt(i-1)) == hm.get('u') || hm.get(s.charAt(i-1))+1 == hm.get('u')) { 
            		in_max++;
            	    max = Math.max(max , in_max);
            	   }
            	   else {
            		   in_max = 1;
            		   for(;i < n && s.charAt(i) != 'a';i++) if(s.charAt(i) == 'a') break;
            	   }
               }
               else if(hm.get(s.charAt(i)) == hm.get(s.charAt(i-1)) || hm.get(s.charAt(i))-1 == hm.get(s.charAt(i-1)))in_max++;
            else {
            	in_max = 1;
            	for(;i < n && s.charAt(i) != 'a';i++) if(s.charAt(i) == 'a') break;
            }
           }
        return max;
    }
}