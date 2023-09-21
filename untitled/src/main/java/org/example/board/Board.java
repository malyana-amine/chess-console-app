package org.example.board;

public class Board {



    public static char[][] initializeChessBoard() {
        char[][] board = new char[8][8];

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if ((row + col) % 2 == 0) {
                    board[row][col] = '■'; // Black squares
                } else {
                    board[row][col] = '□'; // White squares
                }
            }
        }

        return board;
    }

    public static void displayChessBoard(char[][] board) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
}

