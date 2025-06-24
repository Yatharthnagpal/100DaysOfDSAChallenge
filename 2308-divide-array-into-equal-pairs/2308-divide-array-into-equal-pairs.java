class Solution {
    public boolean divideArray(int[] nums) {
        int[] freq = new int[501]; // Frequency array for numbers 1 to 500

        for (int num : nums) {
            freq[num]++; // Count occurrences
        }

        for (int count : freq) {
            if (count % 2 != 0) return false; // If any number has an odd frequency, pairing is impossible
        }

        return true;
    }
}