class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        n = len(matrix)
        m = len(matrix[0])
        total = n * m
        ans = []
        c = 0
        
        rows = 0           # top row
        rowe = n - 1       # bottom row
        cols = 0           # left column
        cole = m - 1       # right column
        
        while c < total:
            # Traverse from left to right (top row)
            for i in range(cols, cole + 1):
                ans.append(matrix[rows][i])
                c += 1
            rows += 1
            if c == total: break

            # Traverse from top to bottom (right column)
            for i in range(rows, rowe + 1):
                ans.append(matrix[i][cole])
                c += 1
            cole -= 1
            if c == total: break

            # Traverse from right to left (bottom row)
            for i in range(cole, cols - 1, -1):
                ans.append(matrix[rowe][i])
                c += 1
            rowe -= 1
            if c == total: break

            # Traverse from bottom to top (left column)
            for i in range(rowe, rows - 1, -1):
                ans.append(matrix[i][cols])
                c += 1
            cols += 1
            if c == total: break

        return ans
