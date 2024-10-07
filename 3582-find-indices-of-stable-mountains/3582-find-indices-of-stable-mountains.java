class Solution {
    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> ls = new ArrayList<>();
        for(int i = 1;i < height.length;i++) if(height[i-1] > threshold) ls.add(i);
        return ls;
    }
}