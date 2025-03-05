class Solution {
    public long coloredCells(int n) {
         long sum = 1;
         int Adder = 4;
         for(int i = 2;i <= n;i++){
             sum += Adder;
             Adder += 4;
         }
         return sum;
    }
}