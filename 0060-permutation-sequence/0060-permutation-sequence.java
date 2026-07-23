class Solution {
    public String getPermutation(int n, int k) {
        int[] f = new int[n + 1];
        f[0] = 1;
        List<Integer> d = new ArrayList<>();
        for (int i = 1; i <= n; i++) { f[i] = f[i - 1] * i; d.add(i); }
        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i >= 1; i--) {
            sb.append(d.remove(k / f[i - 1]));
            k %= f[i - 1];
        }
        return sb.toString();
    }
}