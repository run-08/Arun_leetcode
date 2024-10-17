class Solution {
    public int maximumSwap(int num) {
        StringBuffer sb = new StringBuffer(String.valueOf(num));
        PriorityQueue<Integer> pr = new PriorityQueue<>((a,b) -> b - a);
        while(num != 0){
            pr.add(num % 10);
            num /= 10;
        }
        int first = 0;
        int last = 0;
        int idx = -1;
        for(char c : sb.toString().toCharArray()){
            idx++;
            int data = pr.poll();
            if(Character.getNumericValue(c) != data){ 
                first = idx;
                for(int i = sb.length()-1;i >= 1;i--)  {
                    if(Character.getNumericValue(sb.charAt(i)) == data){
                    last = i;
                    break;
                }
                }
                break;
            }
        }
        char temp = sb.charAt(first);
        if( last != 0)sb.delete(first,first+1);
      if(last != 0)  sb.insert(first,String.valueOf(sb.charAt(last-1)));
        if( last != 0)sb.delete(last,last+1);
        if(last != 0)sb.insert(last,temp);
        return Integer.parseInt(sb.toString());
    }
}