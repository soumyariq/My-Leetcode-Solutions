class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private int[] c;
    private int t;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        c = candidates;
        t = target;
        dfs(0, new ArrayList<>(), 0);
        return res;
    }
    private void dfs(int i, List<Integer> cur, int total) {
        if (total == t) { res.add(new ArrayList<>(cur)); return; }
        if (total > t || i == c.length) return;
        cur.add(c[i]);
        dfs(i + 1, cur, total + c[i]);
        cur.remove(cur.size() - 1);
        while (i + 1 < c.length && c[i] == c[i + 1]) i++;
        dfs(i + 1, cur, total);
    }
}