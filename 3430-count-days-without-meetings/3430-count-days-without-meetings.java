class Solution {
    public int countDays(int days, int[][] meetings) {
        HashMap<Integer , List<Integer>> freq = new HashMap<>();
        List<Integer> ls = new ArrayList<>();
        int n = meetings.length , res = 0;
        for(int[] arr : meetings) {
            ls.add(arr[0]);
            freq.computeIfAbsent(arr[0] , k -> new ArrayList<>()).add(arr[1]);
        }
        Collections.sort(ls);
        int idx = 0;
        for(int val : ls) {
            meetings[idx][0] = val;
            meetings[idx++][1] = freq.get(val).get(0);
            freq.get(val).remove(0);
        }
        res += (meetings[0][0] - 1);
        int max = meetings[0][1];
        for(int i = 1;i < n;i++) {
            if(meetings[i][0] <= max) max = Math.max(meetings[i][1] , max);
            else {
                res += (meetings[i][0] - max) - 1;
                max = meetings[i][1];
            } 
        }
        for(int[] nums : meetings) System.out.print(Arrays.toString(nums));
        res += (days-max);
        return res;
    }
}