class Solution 
{
    public int[] replaceElements(int[] arr) 
    {
        int[] result = new int[arr.length];
        result[arr.length -1] = -1;
        for(int i = arr.length - 2 ; i >= 0 ; i--)
        {
            result[i] = arr[i + 1] < result[i+1] ? result[i + 1] : arr[i + 1] ;
        }
        return result ; 
    }
}