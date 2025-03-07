class Solution {
    int min = Integer.MAX_VALUE;
    public int[] closestPrimes(int left, int right) {
        List<Integer> ls = new ArrayList<>();
        boolean primes[] = new boolean[right+1];
        Arrays.fill(primes , true);
        primes[0] = primes[1] = false;
        for(int i = 2;i*i <= right;i++) for(int j = i*i;j <= right && primes[i];j+=i) primes[j] = false;
        int[] res = new int[2];
        for(;left <= right;left++){
            if(!primes[left]) continue;
            ls.add(left);
        }
        int n = ls.size();
        Arrays.fill(res , -1 );
        for(int i = 0;i < n-1;i++){
            int one = ls.get(i);
            int tow = ls.get(i+1);
            if((tow - one) < min){
                res[0] = one;
                res[1] = tow;
                min = tow-one;
            } 
        }
        return res;
    }
}