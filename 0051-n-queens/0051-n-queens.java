class Solution {
    private List<List<String>> res = new ArrayList<>();
    private boolean[] col, pos, neg;
    private char[][] board;
    private int n;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        col = new boolean[n];
        pos = new boolean[2 * n];
        neg = new boolean[2 * n];
        board = new char[n][n];
        for (char[] r : board) Arrays.fill(r, '.');
        backtrack(0);
        return res;
    }
    private void backtrack(int r) {
        if (r == n) {
            List<String> copy = new ArrayList<>();
            for (char[] row : board) copy.add(new String(row));
            res.add(copy);
            return;
        }
        for (int c = 0; c < n; c++) {
            if (col[c] || pos[r + c] || neg[r - c + n]) continue;
            col[c] = pos[r + c] = neg[r - c + n] = true;
            board[r][c] = 'Q';
            backtrack(r + 1);
            col[c] = pos[r + c] = neg[r - c + n] = false;
            board[r][c] = '.';
        }
    }
}