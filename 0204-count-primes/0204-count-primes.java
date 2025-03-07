class Solution {
    public int countPrimes(int n) {
        boolean[] primes = new  boolean[n];
        int cnt = 0;
        if(n <= 1) return 0; 
        Arrays.fill(primes , true);
        primes[0] = primes[1] = false;
        for(int i = 2;i*i < n;i++){
            if(!primes[i]) continue;
            for(int j = i*i ; j < n;j+=i) primes[j] = false;
        }
        for(boolean isPrime : primes) if(isPrime) cnt++;
        return cnt;
    }
}