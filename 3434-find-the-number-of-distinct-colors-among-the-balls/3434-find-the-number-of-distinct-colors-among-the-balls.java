class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer , Integer> colors = new HashMap<>();
        HashMap<Integer , Integer> balls = new HashMap<>();
        int n = queries.length;
        int[] freq_arr = new int[n];
        int freq = 0;
        int idx = 0;
        
        for(int i = 0;i < n;i++){
           int ball = queries[i][0];
           int color = queries[i][1];
            if(!(balls.containsKey(ball))){
              balls.put(ball , color);
              if(colors.containsKey(color)){
                 colors.put(color , colors.getOrDefault(color,0)+1);
                 freq_arr[idx++] = freq;
              }
              else{
                colors.put(color , 1);
                freq++;
                freq_arr[idx++] = freq; 
              }
            }
            else {
                int inner_color = balls.get(ball);
                // System.out.print(colors);
                balls.put(ball , color);
                if(colors.get(inner_color) == 1) {
                      freq--;
                      colors.remove(inner_color);
                }
                else colors.put(inner_color , colors.get(inner_color)-1);
                if(colors.containsKey(color)){
                     colors.put(color , colors.getOrDefault(color,0)+1);
                     freq_arr[idx++] = freq;
                }
                else {
                    freq++;
                    freq_arr[idx++] = freq;
                    colors.put(color ,1);
                }
            }
        }
        return freq_arr;
    }
}