class MyCalendar {
 List<List<Integer>> set ;
    public MyCalendar() {
        set = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
       List<Integer> temp = new ArrayList<>();
       temp.add(start);
       temp.add(end);
       if(set.size() == 0){
        set.add(0,new ArrayList<>(temp));
        return true;
       }
       if(set.get(0).get(0) >= end){
         set.add(0,new ArrayList<>(temp));
         return true;
       }
       if(set.get(set.size()-1).get(1) <= start) {
        set.add(set.size(),new ArrayList<>(temp));
        return true;
       }
       for(int i = 1;i < set.size();i++){
         if(set.get(i-1).get(1) <= start && set.get(i).get(0) >= end){
            set.add(i,new ArrayList<>(temp));
            return true;
         }
       }
       return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */