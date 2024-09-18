class Solution {
    public String largestNumber(int[] nums) {
        String Data[] = new String[nums.length];
        for(int i = 0;i < nums.length;i++) Data[i] = Integer.toString(nums[i]);
        Arrays.sort(Data,(a , b) -> (b+a).compareTo(a+b));
        if(Data[0].equals("0")) return "0";
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < nums.length;i++) sb.append(Data[i]);
        return sb.toString();
    }
}