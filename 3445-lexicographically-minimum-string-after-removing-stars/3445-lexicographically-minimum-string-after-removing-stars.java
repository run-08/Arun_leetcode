class Solution {
    public String clearStars(String s) {
        int n = s.length();
        PriorityQueue<Sort> pq = new PriorityQueue<>();
        StringBuilder res = new  StringBuilder(s);
        for(int i = 0;i < n;i++) {
            char ch = s.charAt(i);
            if(ch == '*'){
                res.setCharAt(i , '|');
                Sort sort = pq.poll();
                res.setCharAt(sort.idx , '|');
            }
            else pq.offer( new Sort(ch , i) );    
        }
        StringBuilder lexicogrpahicSmallestString = new StringBuilder();
        for(int i = 0;i < n;i++) if(res.charAt(i) != '|') lexicogrpahicSmallestString.append(res.charAt(i));
        return lexicogrpahicSmallestString.toString();
    }
 }

class Sort implements Comparable<Sort>{
    char ch;
    int idx;
    Sort(char ch , int idx){
        this.ch = ch;
        this.idx = idx;
    }
    @Override
    public int compareTo(Sort other){
        if(other.ch != this.ch){
            return Character.compare(this.ch , other.ch);
        }
        return Integer.compare(other.idx , this.idx);
    }
}