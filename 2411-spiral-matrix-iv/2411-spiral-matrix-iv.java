/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int arr[][] = new int[m][n];
        for(int i = 0;i < arr.length;i++){
            for(int j = 0;j < arr[0].length;j++) arr[i][j] = -1;
        }
        right(0,m-1,0,n-1,arr,head);
        return arr;
    }
    public void right(int rowstart,int rowend,int colstart,int colend,int[][] arr,ListNode head){
        if(colstart > colend || rowstart > rowend || head == null) return;
            for(int i = colstart;i <= colend;i++){
                if(head == null) break;
                arr[rowstart][i] = head.val;
                head = head.next;
            }
            rowstart++;
            down(rowstart,rowend,colstart,colend,arr,head);
    }
    public void  down(int rowstart,int rowend,int colstart,int colend,int[][] arr,ListNode head){
        if(colstart > colend || rowstart > rowend || head == null) return;
        for(int i = rowstart;i <= rowend;i++){
            if(head == null) break;
            arr[i][colend] = head.val;
            head = head.next;
        }
        colend--;
        left(rowstart,rowend,colstart,colend,arr,head);
    }
    public void left(int rowstart,int rowend,int colstart,int colend,int[][] arr,ListNode head){
        if(colstart > colend || rowstart > rowend || head == null) return;
        for(int i = colend;i >= colstart;i--){
            if(head == null) break;
            arr[rowend][i] = head.val;
            head = head.next;
        }
        rowend--;
        up(rowstart,rowend,colstart,colend,arr,head);
    }
    public void up(int rowstart,int rowend,int colstart,int colend,int[][] arr,ListNode head){
        if(colstart > colend || rowstart > rowend || head == null) return;
        for(int i = rowend; i >= rowstart;i--){
            if(head == null) return;
            arr[i][colstart] = head.val;
            head = head.next;
        }
        colstart++;
        right(rowstart,rowend,colstart,colend,arr,head);
    }
}