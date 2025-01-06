class Solution {
    public int[] minOperations(String boxes) {
        int[] arr = new int[boxes.length()];
        for(int i = 0;i < boxes.length();i++){
            int idx_sum = 0;
            for(int j = i+1;j < boxes.length();j++) if(boxes.charAt(j) == '1') idx_sum += (j - i);
            for(int j = i-1;j >= 0;j--) if(boxes.charAt(j) == '1') idx_sum += (i - j);
            System.out.print(idx_sum);
            arr[i] = idx_sum;
        }
        return arr;
    }
}