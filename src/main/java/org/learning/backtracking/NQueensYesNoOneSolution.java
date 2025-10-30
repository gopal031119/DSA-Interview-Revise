package org.learning.backtracking;

import java.util.Arrays;

public class NQueensYesNoOneSolution {
    public static void main(String[] args){
        int n=2;
        char[][] board=new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        if(nQueensYesNoOneSolution(board,0)){
            System.out.println(Arrays.deepToString(board));
        } else {
            System.out.println("No Possible Solution");
        }
    }

    private static boolean nQueensYesNoOneSolution(char[][] board, int row) {
        // base case
        if(row==board.length){
            return true;
        }
        // recursion
        for(int j=0;j<board.length;j++){
            if(isSafe(board,row,j)) {
                board[row][j] = 'Q';
                if(nQueensYesNoOneSolution(board, row + 1)){
                    return true;
                }
                board[row][j] = '.';
            }
        }
        return false;
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
