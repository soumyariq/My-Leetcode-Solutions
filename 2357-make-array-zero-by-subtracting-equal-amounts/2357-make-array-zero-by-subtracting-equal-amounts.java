class Solution {
    public int minimumOperations(int[] nums) {
        boolean[] seen = new boolean[101];
        int c = 0;
        for (int x : nums)
            if (x > 0 && !seen[x]) { 
                seen[x] = true; 
                c++; 
            }
        return c;
    }
}