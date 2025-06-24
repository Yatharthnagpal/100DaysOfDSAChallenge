class Solution {
    public int maximumBeauty(int[] nums, int k) {
        // Sort the array
        Arrays.sort(nums);
        int n = nums.length;
        int maxBeauty = 0;

        // Sliding window pointers
        int start = 0;
        for (int end = 0; end < n; end++) {
            // Shrink the window if the difference exceeds 2 * k
            while (nums[end] - nums[start] > 2 * k) {
                start++;
            }
            // Update the maximum beauty
            maxBeauty = Math.max(maxBeauty, end - start + 1);
        }
        
        return maxBeauty;
    }
}