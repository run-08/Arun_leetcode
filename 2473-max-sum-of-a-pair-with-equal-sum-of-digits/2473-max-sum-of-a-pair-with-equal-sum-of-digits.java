class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer,List<Integer>> hm = new HashMap<>();
        HashSet<Integer> hs = new HashSet<>();
        int n = nums.length;
        for(int i = 0;i < n;i++) {
            int digit_sum = produce_sum_of_digits(nums[i]);
            if(hm.containsKey(digit_sum)) {
                List<Integer> ls = hm.get(digit_sum);
                if(ls.size() == 1) ls.add(nums[i]);
                else {
                    int one = ls.get(0);
                    int two = ls.get(1);
                    int[] arr = {one , two ,nums[i]};
                    Arrays.sort(arr);
                    ls.clear();
                    ls.add(arr[1]);
                    ls.add(arr[2]);
                }
                hm.put(digit_sum , new ArrayList<>(ls));
            }
            else {
                List<Integer> ls = new ArrayList<>();
                ls.add(nums[i]);
                hs.add(digit_sum);
                hm.put(digit_sum , new ArrayList<>(ls));
            }
        }
        // System.out.print(hm);
        int max = 0;
        for(int val : hs){
             List<Integer> ls = hm.get(val);
             if(ls.size() <= 1) continue;
             max = Math.max(ls.get(0)+ls.get(1),max);
        }
         return (max != 0) ? max : -1; 
    }
    static int produce_sum_of_digits(int val){
        int sum  = 0;
        while(val > 0) { sum += (val % 10);val /= 10;}
        return sum;
    }
}