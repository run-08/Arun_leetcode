class CustomStack {
     private int[] Array;
     private int size;
     private int counter = -1;
    public CustomStack(int maxSize) {
        this.size = maxSize;
        this.Array = new int[this.size];
    }
    
    public void push(int x) {
        if(this.counter+1 == this.size)return;
        Array[++this.counter] = x;
    }
    
    public int pop() {
        if(this.counter == -1) return -1;
        int Data = Array[this.counter];
        --this.counter;
        return Data;

    }
    
    public void increment(int k, int val) {
        for(int i = 0;i < k && i < Array.length;i++) Array[i] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */