class Solution {
    int[][][] mem;
    private int recursion(int[] prices, int pos, int t, boolean bought) {
        if (pos >= prices.length || t == 0)
            return 0;
        if (mem[bought ? 1 : 0][t][pos] != -1)
            return mem[bought ? 1 : 0][t][pos];
        int result = recursion(prices, pos + 1, t, bought); // Skip
        if (bought)
            result = Math.max(result, recursion(prices, pos + 1, t - 1, false) + prices[pos]); // Sell
        else
            result = Math.max(result, recursion(prices, pos + 1, t, true) - prices[pos]); // Buy
        return mem[bought ? 1 : 0][t][pos] = result;
    }
    public int maxProfit(int[] prices) {
        mem = new int[2][3][prices.length];
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 3; j++)
                java.util.Arrays.fill(mem[i][j], -1);
        return recursion(prices, 0, 2, false);
    }
}