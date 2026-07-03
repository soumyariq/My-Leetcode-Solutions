class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();

        for (int row = 1; row < rows; row++) {
            for (int col = 0; col < triangle.get(row).size(); col++) {
                int prevUpVal = triangle.get(row - 1).get(Math.min(col, triangle.get(row - 1).size() - 1));
                int prevUpLeft = triangle.get(row - 1).get(Math.max(col - 1, 0));

                int updatedVal = triangle.get(row).get(col) + Math.min(prevUpVal, prevUpLeft);
                triangle.get(row).set(col, updatedVal);
            }
        }

        return Collections.min(triangle.get(rows - 1));
    }
}