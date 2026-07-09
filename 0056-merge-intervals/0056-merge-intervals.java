class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));        
        List<int[]> output = new ArrayList<>();
        output.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            int lastEnd = output.get(output.size() - 1)[1];
            if (start <= lastEnd) {
                output.get(output.size() - 1)[1] = Math.max(lastEnd, end);
            } 
            else {
                output.add(new int[]{start, end});
            }
        }        
        return output.toArray(new int[output.size()][]);
    }
}