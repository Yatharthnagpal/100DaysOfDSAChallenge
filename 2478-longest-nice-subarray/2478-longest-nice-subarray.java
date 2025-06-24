class Solution {
    public int longestNiceSubarray(int[] nums) {
        int left = 0, bitmask = 0, maxLen = 0;
        
        for (int right = 0; right < nums.length; right++) {
            while ((bitmask & nums[right]) != 0) {
                bitmask ^= nums[left]; // Remove nums[left] from window
                left++;
            }
            
            bitmask |= nums[right]; // Add nums[right] to window
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}