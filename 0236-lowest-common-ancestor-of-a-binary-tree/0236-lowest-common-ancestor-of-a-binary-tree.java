class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(root.val, null);
        dfs(root, hm);

        List<Integer> ls = new ArrayList<>();
        int s = p.val;
        while (true) {
            ls.add(s);
            if (hm.get(s) == null) break;
            s = hm.get(s);
        }

        int target;
        s = q.val;
        while (true) {
            if (ls.contains(s)) {
                target = s;
                break;
            }
            s = hm.get(s);
        }

        return findTarget(target, root);
    }

    public void dfs(TreeNode root, HashMap<Integer, Integer> hm) {
        if (root == null) return;
        if (root.left != null) hm.put(root.left.val, root.val);
        if (root.right != null) hm.put(root.right.val, root.val);
        dfs(root.left, hm);
        dfs(root.right, hm);
    }

    public TreeNode findTarget(int target, TreeNode root) {
        if (root == null) return null;
        if (root.val == target) return root;

        TreeNode left = findTarget(target, root.left);
        if (left != null) return left;

        return findTarget(target, root.right);
    }
}
