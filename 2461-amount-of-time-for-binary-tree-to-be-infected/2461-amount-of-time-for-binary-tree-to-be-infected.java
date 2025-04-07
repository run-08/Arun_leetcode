class Solution {
    public int amountOfTime(TreeNode root, int start) {
        HashMap<Integer , Queue<Integer>> hm = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            Queue<TreeNode> child = new LinkedList<>();
            while(!q.isEmpty()) {
                TreeNode node = q.poll();
                 if(node.left != null) {
                    hm.computeIfAbsent(node.val , k-> new LinkedList<>()).offer(node.left.val);
                    hm.computeIfAbsent(node.left.val , k -> new LinkedList<>()).offer(node.val);
                    child.offer(node.left);
                 }
                 if(node.right != null) {
                    hm.computeIfAbsent(node.val , k -> new LinkedList<>()).offer(node.right.val);
                    hm.computeIfAbsent(node.right.val , k -> new LinkedList<>()).offer(node.val);
                    child.offer(node.right);
                 }
            }
            if(child.size() > 0) q = child;
        }
       if(!hm.containsKey(start)) return 0;
       Queue<Integer> qq = hm.get(start);
       HashSet<Integer> hs = new HashSet<>();
       int cnt = -1;
       hs.add(start);
       while(!qq.isEmpty()) {
           Queue<Integer> child = new LinkedList<>();
           cnt += 1;
           while(!qq.isEmpty()) {
                Queue<Integer> parentChild = hm.get(qq.poll());
                while(!parentChild.isEmpty()) {
                    int node = parentChild.poll();
                    if(hs.contains(node)) continue;
                    child.offer(node);
                }
           }
           if(child.size() > 0) qq = child;
       }
       return cnt > 1 ?  cnt : 1;
    }
}