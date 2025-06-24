class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) return 9; // Special case for single-digit palindromes

        int upperBound = (int) Math.pow(10, n) - 1; // Largest n-digit number
        int lowerBound = (int) Math.pow(10, n - 1); // Smallest n-digit number

        for (int left = upperBound; left >= lowerBound; left--) {
            // Create the palindrome using the left half
            long palindrome = createPalindrome(left);

            // Check if this palindrome can be factored
            for (long factor = upperBound; factor * factor >= palindrome; factor--) {
                if (palindrome % factor == 0) {
                    long otherFactor = palindrome / factor;
                    if (otherFactor >= lowerBound && otherFactor <= upperBound) {
                        return (int) (palindrome % 1337);
                    }
                }
            }
        }

        return 0; // Should not reach here
    }

    private long createPalindrome(int left) {
        String leftStr = Integer.toString(left);
        StringBuilder rightStr = new StringBuilder(leftStr).reverse();
        return Long.parseLong(leftStr + rightStr);
    }
}
