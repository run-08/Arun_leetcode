class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort ( players );
        Arrays.sort ( trainers );
        int playersLength = players.length , trainersLength = trainers.length;
        int matchedPlayersAndTrainersCount = 0  , playersIndex = 0;
        for ( int index = 0 ; index < trainersLength && playersIndex < playersLength ; index++ ){
            if ( trainers [ index ] >= players [ playersIndex ] ) {
                matchedPlayersAndTrainersCount++;
                playersIndex++;
            }
        }
        return matchedPlayersAndTrainersCount;
    }
}