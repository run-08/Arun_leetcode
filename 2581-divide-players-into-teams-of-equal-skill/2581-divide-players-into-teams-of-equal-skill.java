class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long res = 0;
        long target = skill[0]+skill[skill.length-1];
        for(int i = 0;i < skill.length/2;i++){
            if(skill[i]+skill[skill.length-i-1] != target) return -1;
            res += (skill[i]*skill[skill.length-i-1]);
        }
        return res;
    }
}