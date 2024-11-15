class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        HashMap<Integer , Integer> sumElement = new HashMap<>();
        PriorityQueue<Integer> pr = new PriorityQueue<>();
        for(int[] arr : items1) {
           if(sumElement.containsKey(arr[0])) sumElement.put(arr[0] , sumElement.get(arr[0])+arr[1]);
           else {
            pr.add(arr[0]);
            sumElement.put(arr[0] , arr[1]);
           } 
        }
        for(int[] arr : items2) {
           if(sumElement.containsKey(arr[0])) sumElement.put(arr[0] , sumElement.get(arr[0])+arr[1]);
           else {
            pr.add(arr[0]);
            sumElement.put(arr[0] , arr[1]);
           } 
        }
        List<List<Integer>> res = new ArrayList<>();
        while(pr.size() > 0){
            List<Integer> data = new ArrayList<>();
            data.add(pr.poll());
            data.add(sumElement.get(data.get(0)));
            res.add(new ArrayList<>(data));
        }
        return res;
    }
}