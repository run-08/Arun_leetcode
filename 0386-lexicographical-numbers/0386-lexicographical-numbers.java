class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
       for(int i = 1;i < 10;i++){
        if(i <= n) res.add(i);
        compute(n,String.valueOf(i),res);
       }
       return res;
    }
    public void compute(int n,String num, List<Integer> res){
        for(int i = 0;i <= 9;i++){
            int Data = Integer.parseInt(num+String.valueOf(i));
            if(Data > n) return;
            res.add(Data);
            compute(n,num+String.valueOf(i),res);
        }
    }
}