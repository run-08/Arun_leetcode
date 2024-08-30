class Solution {
    public boolean isValidSudoku(char[][] nums) {
        HashSet<Character> set = new HashSet<>();
        for(int i = 0;i < nums.length;i += 3){
            for(int j = 0;j < nums[0].length;j++){
                if(set.contains(nums[i][j]) || set.contains(nums[i+1][j]) || set.contains(nums[i+2][j])) return false;
                if(nums[i][j] != '.' && nums[i][j] != ',')set.add(nums[i][j]);
                if(nums[i+1][j] != '.' &&  nums[i+1][j] != ',')set.add(nums[i+1][j]);
                if(nums[i+2][j] != '.' && nums[i+2][j] != ',')set.add(nums[i+2][j]);
                if((j+1) % 3 == 0) set.clear();
            }
        }
        for(int i = 0;i < nums.length;i++){
            for(int j = 0;j < nums[0].length;j++){
                if(nums[i][j] == '.' || nums[i][j] == ',') continue;
                if(set.contains(nums[i][j])) return false;
                set.add(nums[i][j]);
            }
            set.clear();
        }
         for(int i = 0;i < nums[0].length;i++){
            for(int j = 0;j < nums.length;j++){
                  if(nums[j][i] == '.' || nums[j][i] == ',') continue;
                if(set.contains(nums[j][i])) return false;
                set.add(nums[j][i]);
            }
            set.clear();
        }
        return true;
    }
}