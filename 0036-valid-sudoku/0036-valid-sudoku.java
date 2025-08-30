class Solution {
    public boolean isValidSudoku(char[][] nums) {
        
        HashSet<Character> set = new HashSet<>();

        for(int i = 0;i < 9;i += 3){
            for(int j = 0;j < 9;j++){
               
                if(nums[i][j] != '.' && nums[i][j] != ',')if(!set.add(nums[i][j])) return false;
                if(nums[i+1][j] != '.' &&  nums[i+1][j] != ',')if(!set.add(nums[i+1][j])) return false;
                if(nums[i+2][j] != '.' && nums[i+2][j] != ',')if(!set.add(nums[i+2][j])) return false;
                if((j+1) % 3 == 0) set = new HashSet <> ();
            }
        }

        for(int i = 0;i < 9;i++){
            for(int j = 0;j < 9;j++){
                if(nums[i][j] == '.' || nums[i][j] == ',') continue;
                if(set.contains(nums[i][j])) return false;
                set.add(nums[i][j]);
            }
            set = new HashSet <> ();
        }


         for(int i = 0;i < 9;i++){
            for(int j = 0;j < 9;j++){
                  if(nums[j][i] == '.' || nums[j][i] == ',') continue;
                if(set.contains(nums[j][i])) return false;
                set.add(nums[j][i]);
            }
            set = new HashSet <> ();
        }


        return true;
    }
}