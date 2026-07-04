class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;
        Arrays.sort(nums);
        reverse(nums);
        int target = sum / k;
        boolean[] used = new boolean[nums.length];
        return backtrack(nums, used, 0, k, 0, target);
    }
    private boolean backtrack(int[] nums, boolean[] used, int i, int k, int subsetSum, int target) {
        if (k == 0) return true;
        if (subsetSum == target)
            return backtrack(nums, used, 0, k - 1, 0, target);
        for (int j = i; j < nums.length; j++) {
            if (used[j] || subsetSum + nums[j] > target)
                continue;
            used[j] = true;
            if (backtrack(nums, used, j + 1, k, subsetSum + nums[j], target))
                return true;
            used[j] = false;
        }
        return false;
    }
    private void reverse(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}