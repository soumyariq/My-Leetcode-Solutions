class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] a, int i) {
        if (i == a.length) {
            List<Integer> l = new ArrayList<>();
            for (int x : a) l.add(x);
            res.add(l);
            return;
        }
        for (int j = i; j < a.length; j++) {
            int t = a[i]; a[i] = a[j]; a[j] = t;
            dfs(a, i + 1);
            t = a[i]; a[i] = a[j]; a[j] = t;
        }
    }
}