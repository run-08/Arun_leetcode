class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int sum = 0;
        for(int i = 0;i < chalk.length;i++){
            if(chalk[i]+sum > k) return i;
            sum += chalk[i]; 
        }
        int temp = sum;
        while(sum+temp <= k) sum += temp;
        temp = 0;
        for(;temp < chalk.length;temp++) {
            if(chalk[temp]+sum <= k) sum += chalk[temp];
            else break;
        }
        return temp;
    }
}