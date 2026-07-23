class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private int[] a;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        a = nums;
        backtrack(0, new ArrayList<>());
        return res;
    }

    private void backtrack(int i, List<Integer> sub) {
        if (i == a.length) { res.add(new ArrayList<>(sub)); return; }
        sub.add(a[i]);
        backtrack(i + 1, sub);
        sub.remove(sub.size() - 1);
        while (i + 1 < a.length && a[i] == a[i + 1]) i++;
        backtrack(i + 1, sub);
    }
}