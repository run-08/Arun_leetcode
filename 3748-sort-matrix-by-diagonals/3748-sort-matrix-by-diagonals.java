class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        HashMap<Integer , List<Integer>> hm = new HashMap<>();
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < n;j++) {
                if(hm.containsKey(i) && hm.get(i).contains(j)) break;
                int col = j;
                int row = i;
                List<Integer> ls = new ArrayList<>();
                while((row < n && row >= 0) && (col >= 0 && col < n)) {
                    ls.add(grid[row][col]);
                    if(hm.containsKey(row)) hm.get(row).add(col);
                    else {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(col);
                        hm.put(row , new ArrayList<>(temp));
                    }
                    row++;
                    col++;
                }
                Collections.sort(ls);
                row = i;
                col = j;
                int size = ls.size();
                if((i > 0) || (i == 0 && j == 0)) {
                    while((row < n && row >= 0) && (col >= 0 && col < n)) {
                    grid[row++][col++] = ls.get(--size);
                    }
                }
                else {
                    int idx = 0;
                    while((row < n && row >= 0) && (col >= 0 && col < n)) {
                    grid[row++][col++] = ls.get(idx++);
                    }
                }
            }
        }
        return grid;
    }
}