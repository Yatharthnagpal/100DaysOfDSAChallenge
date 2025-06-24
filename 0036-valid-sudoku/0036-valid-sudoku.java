class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        // Initialize all HashSets
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // Traverse the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];

                // Skip empty cells
                if (num == '.') continue;

                // Check for duplicate in the row
                if (rows[i].contains(num)) return false;
                rows[i].add(num);

                // Check for duplicate in the column
                if (cols[j].contains(num)) return false;
                cols[j].add(num);

                // Check for duplicate in the 3x3 sub-box
                int boxIndex = (i / 3) * 3 + j / 3;
                if (boxes[boxIndex].contains(num)) return false;
                boxes[boxIndex].add(num);
            }
        }

        // If no violations, the board is valid
        return true;
    }
}