class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> Data = new ArrayList<>();
        Data.add(0);
        AllPath(graph,res,Data,0);
        return res;
    }
    public void AllPath(int[][] arr,List<List<Integer>> res,List<Integer> Data,int index){
        if(index == arr.length-1) res.add(new ArrayList<>(Data));
        for(int i = 0;i < arr[index].length;i++){
            Data.add(arr[index][i]);
            AllPath(arr,res,Data,arr[index][i]);
        }
        if(Data.size() > 0)Data.remove(Data.size()-1);
    }
}