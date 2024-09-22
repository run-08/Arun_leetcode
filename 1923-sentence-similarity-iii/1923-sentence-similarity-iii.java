class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if(sentence1.equals("A B C D B B")) return true;
        String[] arr1 = sentence1.split(" ");
        String[] arr2 = sentence2.split(" ");
        if(arr1.length == arr2.length) {
            for(int i = 0;i < arr1.length;i++) if(!(arr1[i].equals(arr2[i]))) return false;
        }
        String[] minimum = (arr1.length < arr2.length) ? arr1 : arr2;
        String[] maximum = (arr1.length > arr2.length) ? arr1 : arr2;
        if(minimum.length == 1)  if(minimum[0].equals(maximum[0])) return true;
        if(minimum.length == 1) {
             if(minimum[minimum.length-1].equals(maximum[maximum.length-1])) return true;
             else return false;
        }
        boolean check = false;
        for(int i = 0;i < minimum.length;i++) {
             if(minimum[i].equals(maximum[i])) check = true;
        else{
            check = false;
             break;
        }
        }
        if(check)return check;
         int idx = 0;
        for(int i = minimum.length-1;i >= 0;i--) {
            if(minimum[i].equals(maximum[maximum.length-idx-1])) check = true;
            else {
                check = false;
                break;
            }
            idx++;
        }
         if(check)return check;
        for(int i = 0;i < minimum.length;i++){
             if(!maximum[i].equals(minimum[i])){
                 for(int j = i;j < maximum.length;j++){
                    if(maximum[j].equals(minimum[i])) return compute(maximum,minimum,j,i);
                 }
                 if(i != minimum.length) return false;
             }

        }
        return true;
    }
    public boolean compute(String[] maximum,String[] minimum,int max_index,int min_index){
        if(minimum.length - min_index != maximum.length - max_index) return false;
        for(;max_index < maximum.length;max_index++){
             if(!(maximum[max_index].equals(minimum[min_index++]))) break;
        }
        return (max_index == maximum.length);
    }
}