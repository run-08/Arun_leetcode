class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int waterin_watercan = capacity;
        int steps = 0;
        for(int i = 0;i < plants.length;i++){
            steps++;
            if(waterin_watercan < plants[i]){
                steps +=  i + i;
                waterin_watercan = capacity;
            }
            waterin_watercan -= plants[i];
        }
        return steps;
    }
}