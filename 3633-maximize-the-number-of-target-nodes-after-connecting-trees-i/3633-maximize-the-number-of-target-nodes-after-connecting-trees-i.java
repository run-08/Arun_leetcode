class Solution {
    HashMap<Integer , List<Integer>> tree1;
    HashMap<Integer , List<Integer>> tree2;
    int k , cnt;
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        tree1 = new HashMap<>();
        tree2 = new HashMap<>();
        this.k = k;
        if ( k == 0) {
            int[] res = new int[edges1.length+1];
            Arrays.fill(res , 1);
            return res;
        }
        int t1_size = edges1.length , t2_size = edges2.length;
        for(int[] edge : edges1){
            tree1.computeIfAbsent(edge[0] , key -> new ArrayList<>()).add(edge[1]);
            tree1.computeIfAbsent(edge[1] , key -> new ArrayList<>()).add(edge[0]);
        }
        for(int[] edge : edges2){
            tree2.computeIfAbsent(edge[0] , key -> new ArrayList<>()).add(edge[1]);
            tree2.computeIfAbsent(edge[1] , key -> new ArrayList<>()).add(edge[0]);
        }
        int[] tree1KMaxPath = new int[t1_size+1];int[] tree2KMaxPath = new int[t2_size+1];
        for(int i = 0;i <= t1_size;i++) {
            dfs( new HashSet<>() , i , 1 , 0);
            tree1KMaxPath[i] = cnt;
            cnt = 0;
       }
       this.k -= 1;
       for(int i = 0;i <= t2_size;i++) {
            dfs( new HashSet<>() , i , 2 , 0);
            tree2KMaxPath[i] = cnt;
            cnt = 0;
       }
       int maxPath = 0;
       for(int path : tree2KMaxPath) maxPath = Math.max(path , maxPath);
       for(int i = 0;i <= t1_size;i++) tree1KMaxPath[i] += maxPath; 
       return tree1KMaxPath;
    }
    private void dfs(HashSet<Integer> visited , int node , int tree , int path  ){
        visited.add(node);
        if(path == k) {
            cnt++;
            return;
        }
        cnt++;
        List<Integer> children = ( tree == 1) ? tree1.get(node) : tree2.get(node);
        for(int child : children){
             if(visited.contains(child)) continue;
             dfs(visited , child , tree , path+1);
        }
    }
}