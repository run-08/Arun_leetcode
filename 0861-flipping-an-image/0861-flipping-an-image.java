class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        // We Construct The Res Array For Storing The Result in This Array
        int[][] res = new int[image.length][image[0].length];
        // Lets Flip The Each Inner Array Of image as Horizontally(Just Reverse of it )
        for(int i = 0;i < image.length;i++) {
            for(int j = 0;j < image[0].length;j++) {
                res[i][j] = image[i][image[0].length-j-1] ^ 1;
            }
        }
        return res;
    }
}