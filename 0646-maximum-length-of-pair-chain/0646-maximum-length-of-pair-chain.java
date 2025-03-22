class Solution {
    public int findLongestChain(int[][] pairs) {
        HashMap<Integer , List<Integer>> hm = new HashMap<>();
        List<Integer> elements = new ArrayList<>();
        for(int[] arr : pairs) {
            hm.computeIfAbsent(arr[0] , k -> new ArrayList<>()).add(arr[1]);
            elements.add(arr[0]);
        }
        elements = new ArrayList<>(new HashSet<>(elements));
        Collections.sort(elements);
        int n = pairs.length , max = -1001 , idx = 0;
        int[] dp = new int[n];
        int[][] nums = new int[n][2];
        for(int key : elements) {
             List<Integer> freq = hm.get(key);
             for(int val : freq) {
                nums[idx][0] = key;
                nums[idx++][1] = val; 
             }
        }
        dp[0] = 1;
        for(int i = 1;i < n;i++) {
            dp[i] = 1;
            for(int j = 0;j < i;j++) if(nums[i][0] > nums[j][1]) dp[i] = Math.max(dp[j]+1 , dp[i]);
        }
        for(int val : dp)  max = Math.max(val , max);
        return max;
    }
}