class Solution {
    public String addBinary(String a, String b) {
         StringBuilder result = new StringBuilder();
        int carry = 0;
        
        // Pointers for a and b
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        // Traverse both strings from right to left
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry; // Start with carry
            
            // Add the binary digit from string a
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            
            // Add the binary digit from string b
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            
            // Append the current bit (sum % 2) to the result
            result.append(sum % 2);
            
            // Update carry (sum / 2)
            carry = sum / 2;
        }
        
        // Reverse the result since we added digits from the least significant
        return result.reverse().toString();
    }
}