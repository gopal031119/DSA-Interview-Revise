package org.learning.backtracking;

import java.util.Arrays;

public class NQueensPossibleSolution {
    public static void main(String[] args){
        int n=4;
        char[][] board=new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        nQueensPossibleSolution(board,0);
    }

    private static void nQueensPossibleSolution(char[][] board, int row) {
        // base case
        if(row==board.length){
            System.out.println(Arrays.deepToString(board));
            return;
        }
        // recursion
        for(int j=0;j<board.length;j++){
            if(isSafe(board,row,j)) {
                board[row][j] = 'Q';
                nQueensPossibleSolution(board, row + 1);
                board[row][j] = '.';
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        // vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // left diagonal up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // right diagonal up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
