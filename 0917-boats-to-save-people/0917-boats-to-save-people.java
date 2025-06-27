class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int end = people.length-1 , start = 0 , cnt = 0;
        while(end >= start) {
            if( people[start]+people[end] <= limit ) {
                start++;
                end--;
            }
            else end--;
            cnt++;
        }
        return cnt;
    }
}