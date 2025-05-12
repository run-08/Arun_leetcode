class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] arr = new int[10];
        for(int val : digits) arr[val]++;
        List<Integer> ls = new ArrayList<>();
        for(int i = 100;i < 1000;i++){
            int[] freq = new int[10];
            int n = i;
            boolean isSatisfied = true;
            while( n != 0 && isSatisfied){
                int digit = n % 10;
                freq[digit]++;
                if(freq[digit] > arr[digit]) isSatisfied = false;
                n /= 10;
            }
            if(isSatisfied && i % 2 == 0) ls.add(i);
        }
        int[] res = new int[ls.size()];
        int idx = 0;
        for(int val : ls) res[idx++] = val;
        return res;
    }
}