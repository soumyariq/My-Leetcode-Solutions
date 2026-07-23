class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] cnt = new int[26];
        int mx = 0, mc = 0;
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            if (++cnt[i] > mx) { mx = cnt[i]; mc = i; }
        }
        if (mx > (n + 1) / 2) return "";
        char[] r = new char[n];
        int p = 0;
        while (cnt[mc]-- > 0) { r[p] = (char) (mc + 'a'); p += 2; }
        for (int i = 0; i < 26; i++)
            while (cnt[i]-- > 0) {
                if (p >= n) p = 1;
                r[p] = (char) (i + 'a');
                p += 2;
            }
        return new String(r);
    }
}