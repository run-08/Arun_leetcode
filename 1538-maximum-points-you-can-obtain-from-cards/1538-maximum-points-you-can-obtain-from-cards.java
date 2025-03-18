class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0 , n = cardPoints.length , max = 0;
        for(int i = n-k;i < n;i++) sum += cardPoints[i];
        max = sum;
        for(int i = 0;i < k;i++) {
            sum += cardPoints[i];
            sum -= cardPoints[(n-k)+i];
            max = Math.max(sum , max);
        }
        return max;
    }
}