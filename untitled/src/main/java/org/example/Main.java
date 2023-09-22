package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
        printChessboard(board);

        boolean isBlackTurn = true; // Initialize with black's turn

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String currentPlayer = isBlackTurn ? "Black" : "White";
            System.out.println(currentPlayer + "'s turn.");

            System.out.println("Enter the current position (e.g., 'b7'): ");
            String currentPosition = scanner.next();
            System.out.println("Enter the new position (e.g., 'b5'): ");
            String newPosition = scanner.next();

            int currentRow = 8 - (currentPosition.charAt(1) - '0');
            int currentCol = currentPosition.charAt(0) - 'a';
            int newRow = 8 - (newPosition.charAt(1) - '0');
            int newCol = newPosition.charAt(0) - 'a';

            if (isValidMove(board, currentRow, currentCol, newRow, newCol, isBlackTurn)) {
                board[newRow][newCol] = board[currentRow][currentCol];
                board[currentRow][currentCol] = "[  ]";
                printChessboard(board);
                isBlackTurn = !isBlackTurn; // Switch turns
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    // Function to print the chessboard
    public static void printChessboard(String[][] board) {
        System.out.print("  a  b  c  d  e  f  g  h\n"); // Column labels
        for (int row = 0; row < 8; row++) {
            System.out.print((8 - row) + " "); // Row labels
            for (int col = 0; col < 8; col++) {
                System.out.print(board[row][col]);
            }
            System.out.println(); // Move to the next row
        }
    }

    // Function to check if a move is valid
// Function to check if a move is valid
    public static boolean isValidMove(String[][] board, int currentRow, int currentCol, int newRow, int newCol, boolean isBlackTurn) {
        // Check if the source and destination positions are within the board bounds
        if (currentRow < 0 || currentRow >= 8 || currentCol < 0 || currentCol >= 8 ||
                newRow < 0 || newRow >= 8 || newCol < 0 || newCol >= 8) {
            return false;
        }

        // Check if the destination square is not occupied by a friendly piece
        if (board[newRow][newCol].charAt(1) == board[currentRow][currentCol].charAt(1)) {
            return false; // Destination square has a friendly piece
        }
        if (!(board[currentRow][currentCol].equals("[♟]") || board[currentRow][currentCol].equals("[♙]"))) {
            return false;
        }

        // Determine the direction of movement based on the player's turn
        int direction = isBlackTurn ? 1 : -1;

        // Pawn moves forward
        if (currentCol == newCol && currentRow + direction == newRow && board[newRow][newCol].equals("[  ]")) {
            return true;
        }

        // Pawn moves two squares forward on its first move
        if (currentCol == newCol && currentRow + 2 * direction == newRow && currentRow == (isBlackTurn ? 1 : 6) && board[newRow][newCol].equals("[  ]")) {
            return true;
        }

        // Pawn captures diagonally
        if (Math.abs(newCol - currentCol) == 1 && currentRow + direction == newRow &&
                board[newRow][newCol].charAt(1) != board[currentRow][currentCol].charAt(1)) {
            return true;
        }

        return false; // Invalid move
    }

    }

