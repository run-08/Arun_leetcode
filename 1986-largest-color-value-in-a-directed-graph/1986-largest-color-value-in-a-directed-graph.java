class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        HashMap<Integer , List<Integer>> hm = new HashMap<>();
        int n = colors.length();
        for(int i = 0;i < n;i++) hm.put(i,new ArrayList<>());
        int[][] dp = new int[n][26];
        Queue<Integer> q = new LinkedList<>();
        for(int[] edge : edges) hm.get(edge[0]).add(edge[1]);
        int[] indegree = new int[n];
        for(int i = 0;i < n;i++) for(int child : hm.get(i)) indegree[child]++;
        for(int i = 0;i < n;i++) if(indegree[i] == 0) q.offer(i);
        int visited = 0;
        while(!q.isEmpty()) {
            int u = q.poll();
            visited++;
            int c = colors.charAt(u)-97;
            dp[u][c] += 1;
            for(int child : hm.get(u)) {
                for(int i = 0;i < 26;i++) dp[child][i] = Math.max(dp[child][i] , dp[u][i]);
                indegree[child]--;
                if(indegree[child] == 0) q.offer(child);
            }
        }
        if(visited != n) return -1;
        int res = 0;
        for(int[] colorses : dp) for(int color : colorses) res = Math.max( color , res ); 
        return res == 0 ? -1 : res;
    }
}