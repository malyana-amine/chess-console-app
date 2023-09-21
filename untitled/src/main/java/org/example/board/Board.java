package org.example.board;

public class Board {

    public void CBoard() {


        String[][] board = new String[8][8];

        // Initialize the chessboard with empty spaces
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                board[row][col] = "[  ]";
            }
        }

        // Place all the chess pieces on the board
        board[0][0] = "[♜]"; // Black Rook
        board[0][1] = "[♞]"; // Black Knight
        board[0][2] = "[♝]"; // Black Bishop
        board[0][3] = "[♛]"; // Black Queen
        board[0][4] = "[♚]"; // Black King
        board[0][5] = "[♝]"; // Black Bishop
        board[0][6] = "[♞]"; // Black Knight
        board[0][7] = "[♜]"; // Black Rook

        board[1][0] = "[♟]"; // Black Pawn
        board[1][1] = "[♟]"; // Black Pawn
        board[1][2] = "[♟]"; // Black Pawn
        board[1][3] = "[♟]"; // Black Pawn
        board[1][4] = "[♟]"; // Black Pawn
        board[1][5] = "[♟]"; // Black Pawn
        board[1][6] = "[♟]"; // Black Pawn
        board[1][7] = "[♟]"; // Black Pawn

        board[7][0] = "[♖]"; // White Rook
        board[7][1] = "[♘]"; // White Knight
        board[7][2] = "[♗]"; // White Bishop
        board[7][3] = "[♕]"; // White Queen
        board[7][4] = "[♔]"; // White King
        board[7][5] = "[♗]"; // White Bishop
        board[7][6] = "[♘]"; // White Knight
        board[7][7] = "[♖]"; // White Rook

        board[6][0] = "[♙]"; // White Pawn
        board[6][1] = "[♙]"; // White Pawn
        board[6][2] = "[♙]"; // White Pawn
        board[6][3] = "[♙]"; // White Pawn
        board[6][4] = "[♙]"; // White Pawn
        board[6][5] = "[♙]"; // White Pawn
        board[6][6] = "[♙]"; // White Pawn
        board[6][7] = "[♙]"; // White Pawn

        // Print the chessboard with row and column labels
    }
    // Function to print the chessboard
    public void printChessboard(String[][] board) {
        System.out.print("  a  b  c  d  e  f  g  h\n"); // Column labels
        for (int row = 0; row < 8; row++) {
            System.out.print((8 - row) + " "); // Row labels
            for (int col = 0; col < 8; col++) {
                System.out.print(board[row][col]);
            }
            System.out.println(); // Move to the next row
        }
    }
}

