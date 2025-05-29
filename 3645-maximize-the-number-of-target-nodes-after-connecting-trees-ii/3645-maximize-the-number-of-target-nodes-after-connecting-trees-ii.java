class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length+1, m = edges2.length+1;

        List<List<Integer>> tree1 = new ArrayList<>();
        List<List<Integer>> tree2 = new ArrayList<>();

        for (int i = 0; i < n; i++) tree1.add(new ArrayList<>());
        for (int i = 0; i < m; i++) tree2.add(new ArrayList<>());

        for (int[] edge : edges1) {
            tree1.get(edge[0]).add(edge[1]);
            tree1.get(edge[1]).add(edge[0]);
        }

        for (int[] edge : edges2) {
            tree2.get(edge[0]).add(edge[1]);
            tree2.get(edge[1]).add(edge[0]);
        }

        int[] tree1Color = new int[n];int[] tree2Color = new int[m];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        HashSet<Integer> visited = new HashSet<>();

        while(!q.isEmpty()) {
            int node[] = q.poll();
            if(visited.contains(node[0])) continue;
            tree1Color[node[0]] = node[1];
            visited.add(node[0]);
            List<Integer> children = tree1.get(node[0]);
            for(int child : children) {
                if(!visited.contains(child)) q.offer(new int[]{child , node[1]^1});
            }  
        }
        visited.clear();

        q.offer(new int[]{0,0});
        while(!q.isEmpty()) {
            int node[] = q.poll();
            if(visited.contains(node[0])) continue;
            tree2Color[node[0]] = node[1];
            visited.add(node[0]);
            List<Integer> children = tree2.get(node[0]);
            for(int child : children) {
                if(!visited.contains(child)) q.offer(new int[]{child , node[1]^1});
            }  
        }
        int oddCnt = 0 , evenCnt = 0;
        int zeros = 0 , ones = 0;
        for(int color : tree1Color){
            if(color == 1) ones++;
            else zeros++;
        }
        for(int i = 0;i < n;i++) {
            if(tree1Color[i] == 1) tree1Color[i] = ones;
            else tree1Color[i] = zeros;
        }
        for(int color : tree2Color) {
            if(  (color&1) == 1  ) oddCnt++;
            else evenCnt++;
        }
        oddCnt = Math.max(evenCnt , oddCnt);
        for(int i = 0;i < n;i++) tree1Color[i] += oddCnt;
        System.out.print(Arrays.toString(tree1Color));
        return tree1Color;
    }
}
