class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            long xi = bombs[i][0];
            long yi = bombs[i][1];
            long ri = bombs[i][2];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                long xj = bombs[j][0];
                long yj = bombs[j][1];
                long dx = xi - xj;
                long dy = yi - yj;
                if (dx * dx + dy * dy <= ri * ri) {
                    graph.get(i).add(j);
                }
            }
        }
        int ans = 1;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, bfs(i, graph, n));
        }
        return ans;
    }
    private int bfs(int startIndex, List<List<Integer>> graph, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(startIndex);
        visited[startIndex] = true;
        int count = 1;
        while (!queue.isEmpty()) {
            int bomb = queue.poll();
            for (int neighbor : graph.get(bomb)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                    count++;
                }
            }
        }
        return count;
    }
}