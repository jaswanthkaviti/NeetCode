package org.example;

import java.util.HashSet;

public class HashingSudokuValidation {
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(board)); // Output: true
    }

    private static boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {           // rows
            for (int j = 0; j < 9; j++) {       // columns
                char current = board[i][j];

                if (current != '.') {
                    // Check row
                    if (!seen.add(current + " in row " + i)) return false;

                    // Check column
                    if (!seen.add(current + " in col " + j)) return false;

                    // Check 3x3 sub-box
                    int boxRow = i / 3;
                    int boxCol = j / 3;
                    if (!seen.add(current + " in box " + boxRow + "-" + boxCol)) return false;
                }
            }
        }
        return true;
    }
}
