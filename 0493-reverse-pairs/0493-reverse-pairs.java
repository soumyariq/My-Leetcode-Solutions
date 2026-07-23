class Solution {
    public int reversePairs(int[] nums) {
        return sort(nums, 0, nums.length - 1, new int[nums.length]);
    }

    private int sort(int[] a, int l, int r, int[] t) {
        if (l >= r) return 0;
        int m = (l + r) >>> 1;
        int c = sort(a, l, m, t) + sort(a, m + 1, r, t);
        for (int i = l, j = m + 1; i <= m; i++) {
            while (j <= r && (long) a[i] > 2L * a[j]) j++;
            c += j - m - 1;
        }
        int i = l, j = m + 1, k = l;
        while (i <= m && j <= r) t[k++] = a[i] <= a[j] ? a[i++] : a[j++];
        while (i <= m) t[k++] = a[i++];
        while (j <= r) t[k++] = a[j++];
        System.arraycopy(t, l, a, l, r - l + 1);
        return c;
    }
}