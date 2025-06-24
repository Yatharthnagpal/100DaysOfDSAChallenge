class Solution {
    public int maximumLength(String s) {
        int n = s.length();

        // Check substrings of decreasing lengths
        for (int length = n; length > 0; length--) {
            HashMap<String, Integer> substrCount = new HashMap<>();
            
            // Extract all substrings of the current length
            for (int i = 0; i <= n - length; i++) {
                String substring = s.substring(i, i + length);
                
                // Check if the substring is special
                if (isSpecial(substring)) {
                    substrCount.put(substring, substrCount.getOrDefault(substring, 0) + 1);
                }
            }

            // Check if any special substring occurs at least thrice
            for (int count : substrCount.values()) {
                if (count >= 3) {
                    return length;
                }
            }
        }
        
        // If no valid substring is found
        return -1;
    }

    // Helper function to check if a substring is special
    private boolean isSpecial(String s) {
        char first = s.charAt(0);
        for (char c : s.toCharArray()) {
            if (c != first) {
                return false;
            }
        }
        return true;
    }
}