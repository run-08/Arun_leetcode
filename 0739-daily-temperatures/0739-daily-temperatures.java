
import java.util.AbstractMap;
class Solution {
    public int[] dailyTemperatures(int[] t) {
        Stack<Map.Entry<Integer,Integer>> stack = new Stack<>();
       stack.push(new AbstractMap.SimpleEntry<>(0,t[0]));
        for(int i = 1;i < t.length;i++){
            if(stack.peek().getValue() < t[i]){
                 while(!stack.isEmpty()){
                    int val = stack.peek().getValue();
                    if(val < t[i]) {
                          Map.Entry<Integer,Integer> map = stack.pop();
                          t[map.getKey()] = i - map.getKey();
                    }
                    else break;
                }
            }
            stack.push(new AbstractMap.SimpleEntry<>(i,t[i]));
        }
        while(!stack.isEmpty()){
            Map.Entry<Integer,Integer> map = stack.pop();
             t[map.getKey()] = 0;
        }
        return t;
    }
}