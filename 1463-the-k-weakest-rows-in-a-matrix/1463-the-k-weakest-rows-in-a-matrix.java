class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] res = new int[k];
        int[] Data = new int[mat.length];
        for(int i = 0;i < mat.length;i++) for(int j = 0;j < mat[0].length && mat[i][j] == 1;j++) Data[i] += 1;
        HashMap<Integer , List<Integer>> hm = new HashMap<>();
        PriorityQueue<Integer> pr = new PriorityQueue<>();
        for(int i = 0;i < Data.length;i++){
            if(hm.containsKey(Data[i])){
                List<Integer> ls = hm.get(Data[i]);
                ls.add(i);
                hm.put(Data[i],new ArrayList<>(ls));
            }
            else{
                pr.offer(Data[i]);
                List<Integer> ls = new ArrayList<>();
                ls.add(i);
                hm.put(Data[i],new ArrayList<>(ls));
            }
        }
        System.out.print(hm+"\n"+pr);
        int idx = 0;
        while(idx != k){
            List<Integer> ls = hm.get(pr.poll());
            for(int i = 0;i < ls.size() && idx != k;i++) res[idx++] = ls.get(i);
        }
        return res;
    }
}