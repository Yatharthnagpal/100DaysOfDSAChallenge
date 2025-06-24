class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; // Number of rows
        int n = matrix[0].length; // Number of columns

        int left = 0, right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Map 1D index back to 2D indices
            int row = mid / n;
            int col = mid % n;
            int midValue = matrix[row][col];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}