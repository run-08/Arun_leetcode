class FreqStack {
   PriorityQueue<StackElements> pq; 
   int index , cnt;
   HashMap<Integer , Integer> freq;
    public FreqStack() {
        pq = new PriorityQueue<>((a , b) -> {
            if(a.cnt != b.cnt) return b.cnt - a.cnt;
            else return b.index - a.index;
        });
        freq = new HashMap<>();
        int index = 0;
    }
    public void push(int val) {
        index++;
        freq.put(val , freq.getOrDefault(val , 0)+1);
         pq.offer(new StackElements(freq.get(val) , index  , val));
    }
    public int pop() {
        StackElements stackElements = pq.poll();
        freq.put(stackElements.val , freq.getOrDefault(stackElements.val , 0)-1);
        return stackElements.val;
    }
    class StackElements{
        int cnt , index ,  val;
        public StackElements(int cnt , int index , int val){
            this.cnt = cnt;
            this.index = index;
            this.val = val;
        }
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */