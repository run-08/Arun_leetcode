class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int size = rectangles.length ;
        int[][] x = new int[size][2];
        int[][] y = new int[size][2];
        int idx = 0;
        for(int arr[] : rectangles) {
           x[idx][0] = arr[0];
           x[idx][1] = arr[2];
           y[idx][0] = arr[1];
           y[idx][1] = arr[3];
           idx++;
        }
        Arrays.sort(x , (a , b) -> Integer.compare(a[0] , b[0]));
        Arrays.sort(y , (a , b) -> Integer.compare(a[0] , b[0]));
        int max = x[0][1];
        int cnt = 1;
        for(int i = 1;i < size;i++) {
            if(x[i][0] < max) max = Math.max(x[i][1] , max);
            else {
                cnt++;
                max = x[i][1];
            }
        }
        if(cnt >= 3) return true;
        max = y[0][1];
        System.out.print(cnt);
        cnt = 1;
        for(int i = 1;i < size ;i++) {
            if(y[i][0] < max) max = Math.max(y[i][1] , max);
            else {
                cnt++;
                max = y[i][1];
            }
        }
        return cnt >= 3;
    }
}