class Solution {
public:
    bool query(vector<bool> &tree,vector<int> &nums, int qi , int qj, int root, int ci, int cj){
        if (ci >= qi && cj <= qj) return tree[root];
        if (cj < qi || ci > qj) return true;
        int l, r, m;
        l = 2*root + 1;
        r = l+1;
        m = (ci+cj)/2;
        if (query(tree,nums, qi, qj, l, ci, m) == false || query(tree,nums, qi, qj, r, m+1, cj) == false) return false;
        //cout <<qi<<" "<<qj<<" "<<ci <<" "<<cj <<endl;
        if (m >= qi && (m+1) <= qj) {
            if ((nums[m]+nums[m+1])%2 == 0) return false;
        }
        return true;
    }
    bool build(vector<bool> &tree, vector<int> &nums, int i , int j, int root){
        if (i == j){
            tree[root] = true;
            return true;
        }
        int l, r, m;
        l = 2*root + 1;
        r = l+1;
        m = (i+j)/2;
        build(tree, nums, i, m, l);
        build(tree, nums, m+1, j, r);
        tree[root] = tree[l] & tree[r] & ((nums[m]+nums[m+1])%2);
        return tree[root];
    }
    vector<bool> isArraySpecial(vector<int>& nums, vector<vector<int>>& queries) {
        int size = nums.size();
        vector<bool> tree(4*size);
        build(tree, nums, 0, size-1, 0);
        vector<bool> rtn;
        for (vector<int> &i: queries){
            rtn.emplace_back(query(tree, nums, i[0], i[1], 0, 0, size-1));
        }
        return rtn;
    }
};