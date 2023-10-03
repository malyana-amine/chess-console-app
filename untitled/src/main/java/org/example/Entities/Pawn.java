package org.example.Entities;

public class Pawn extends Piece{
    public Pawn(String symbol, ColorEnum color) {
        super(symbol, color);
    }

    @Override
    public boolean IsValidMove(String[][] board, int currentRow, int currentCol, int newRow, int newCol, boolean isBlackTurn) {




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

        return false;
    }
}
