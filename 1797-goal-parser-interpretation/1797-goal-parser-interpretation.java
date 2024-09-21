class Solution {
    public String interpret(String command) {
        String res = "";
        for(int i = 0;i < command.length();i++){
            if(command.charAt(i) == ')') continue;
            if(command.charAt(i) == '(' && command.charAt(i+1) == ')') res += "o";
            if(command.charAt(i) =='(' && command.charAt(i+1) != ')'){
                i += 3;
                 res += "al";
                 continue;
            }
            if(command.charAt(i) != '(') res += command.charAt(i);
        }
        return res;
    }
}