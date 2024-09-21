class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
         int res = 0;
        int num = (ruleKey.equals("color") ) ? 2 : (ruleKey.equals("type")) ? 1 : 3;
        System.out.print(num);
        for(int i = 0;i < items.size();i++){
            List<String> temp = items.get(i);
            if(temp.get(num-1).equals(ruleValue)) res++;
        }
        return res;
    }
}