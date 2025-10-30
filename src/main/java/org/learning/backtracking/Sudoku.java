package org.learning.backtracking;

public class Sudoku {

    // Size of the Sudoku grid (9x9)
    private static final int SIZE = 9;

    public static void main(String[] args) {
        // Initial Sudoku board, 0 represents empty cells
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        // Try to solve the Sudoku puzzle
        if (solveSudoku(board, 0, 0)) {
            System.out.println("Solved Sudoku:");
            printBoard(board); // Print solved board
        } else {
            System.out.println("No solution exists.");
        }
    }

    /**
     * Recursive backtracking function to solve the Sudoku
     *
     * @param board Sudoku board
     * @param row   current row
     * @param col   current column
     * @return true if solution exists, false otherwise
     */
    private static boolean solveSudoku(int[][] board, int row, int col) {
        // Base case: reached end of the board
        if (row == SIZE) {
            return true; // Sudoku solved
        }

        // Determine next cell coordinates
        int nextRow = row;
        int nextCol = col + 1;
        if (col + 1 == SIZE) { // move to next row if end of column
            nextRow = row + 1;
            nextCol = 0;
        }

        // If cell is already filled, skip it
        if (board[row][col] != 0) {
            return solveSudoku(board, nextRow, nextCol);
        }

        // Try numbers 1 to 9 in the current empty cell
        for (int num = 1; num <= 9; num++) {
            if (isValid(board, row, col, num)) { // check if num can be placed
                board[row][col] = num; // place number

                // Recursively try to fill the next cell
                if (solveSudoku(board, nextRow, nextCol)) {
                    return true; // found a valid solution
                }

                board[row][col] = 0; // backtrack if no solution ahead
            }
        }

        return false; // no valid number found for this cell
    }

    /**
     * Check if placing a number in a cell is valid according to Sudoku rules
     *
     * @param board Sudoku board
     * @param row   row index
     * @param col   column index
     * @param num   number to place
     * @return true if valid, false otherwise
     */
    private static boolean isValid(int[][] board, int row, int col, int num) {
        // Check row and column for duplicates
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num || board[i][col] == num)
                return false;
        }

        // Check 3x3 subgrid
        int startRow = row - row % 3; // top-left row of subgrid
        int startCol = col - col % 3; // top-left column of subgrid
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num)
                    return false;
            }
        }

        return true; // no conflicts found
    }

    /**
     * Print the Sudoku board in a readable format
     *
     * @param board Sudoku board
     */
    private static void printBoard(int[][] board) {
        for (int r = 0; r < SIZE; r++) {
            if (r % 3 == 0 && r != 0) // add horizontal separator every 3 rows
                System.out.println("------+-------+------");
            for (int c = 0; c < SIZE; c++) {
                if (c % 3 == 0 && c != 0) // add vertical separator every 3 columns
                    System.out.print("| ");
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }
}
