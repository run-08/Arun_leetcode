
class Solution {
    public int minimumOperations(TreeNode root) {
      Queue<TreeNode> q = new LinkedList<>();
      q.offer(root);
      int cnt = 0;
       while(!q.isEmpty()){
          HashMap<Integer , Integer> hm = new HashMap<>();
          List<Integer> ls = new ArrayList<>();
          Queue<TreeNode> child = new LinkedList<>();
          int idx = 0;
          while(!q.isEmpty()){
              TreeNode node = q.poll();
              if(node.left != null) {
                 ls.add(node.left.val);
                 hm.put(node.left.val,idx++);
                 child.offer(node.left);
              }
              if(node.right != null) {
                 ls.add(node.right.val);
                 hm.put(node.right.val,idx++);
                 child.offer(node.right);
              }
          }
           cnt += Noofmismatch(hm , ls);
           if(!child.isEmpty()) q = child;
       }
        return cnt;
    }
    public int Noofmismatch (HashMap<Integer , Integer> hm , List<Integer> ls){
        int cnt = 0;
        List<Integer> sortedArray = new ArrayList<>(ls);
        Collections.sort(sortedArray);
        for(int i = 0;i < ls.size();i++) {
            if(ls.get(i).equals(sortedArray.get(i))) continue;
                cnt++;
                int idx = hm.get(sortedArray.get(i));
                int temp = ls.get(i);
                ls.set(idx , temp);
                ls.set(i,sortedArray.get(i));
                hm.put(ls.get(i),i);
                hm.put(temp , idx);
                // System.out.print(ls);
        }
        return cnt;
    }
}