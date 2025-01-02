class Solution {
    public int findChampion(int n, int[][] edges) {
        int arr[] = new int[n];
        for(int edge[] : edges) arr[edge[1]] += 1;
        int champion = -1;
        int idx = 0;
        for(int node_count : arr) {
            if(node_count == 0 && champion != -1) return -1;
            if(node_count == 0) champion = idx;
            idx++;
        }
        return champion ;
    }
}