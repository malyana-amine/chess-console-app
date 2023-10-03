package org.example.board;

import org.example.Entities.*;

import java.util.Scanner;

public class ChessGame {
    public String[][] board;
    public boolean isBlackTurn;
    private Scanner scanner;

    public ChessGame() {
        board = new String[8][8];
        isBlackTurn = true;
        scanner = new Scanner(System.in);

        initializeBoard();
    }

    private void initializeBoard() {
        // Initialize the chessboard with empty spaces
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                board[row][col] = "[ ]";
            }
        }


        Rook BlackRook = new Rook("[♜]", ColorEnum.BLACK);
        Knight BlackKnight = new Knight("[♞]", ColorEnum.BLACK);
        Bishop BlackBishop = new Bishop("[♝]", ColorEnum.BLACK);
        Queen blackQueen = new Queen("[♛]", ColorEnum.BLACK);
        King blackKing = new King("[♚]", ColorEnum.BLACK);

        board[0][0] = BlackRook.getSymbol(); // Black Rook
        board[0][1] = BlackKnight.getSymbol(); // Black Knight
        board[0][2] = BlackBishop.getSymbol(); // Black Bishop
        board[0][3] = blackQueen.getSymbol(); // Black Queen
        board[0][4] = blackKing.getSymbol(); // Black King
        board[0][5] = BlackBishop.getSymbol(); // Black Bishop
        board[0][6] = BlackKnight.getSymbol(); // Black Knight
        board[0][7] = BlackRook.getSymbol(); // Black Rook

        Pawn BlackPawn = new Pawn("[♟]", ColorEnum.BLACK);

        board[1][0] = BlackPawn.getSymbol(); // Black Pawn
        board[1][1] = BlackPawn.getSymbol();// Black Pawn
        board[1][2] = BlackPawn.getSymbol(); // Black Pawn
        board[1][3] = BlackPawn.getSymbol(); // Black Pawn
        board[1][4] = BlackPawn.getSymbol(); // Black Pawn
        board[1][5] = BlackPawn.getSymbol(); // Black Pawn
        board[1][6] = BlackPawn.getSymbol(); // Black Pawn
        board[1][7] = BlackPawn.getSymbol(); // Black Pawn


        Rook WhiteRook = new Rook("[♖]", ColorEnum.WHITE);
        Knight WhiteKnight = new Knight("[♘]", ColorEnum.WHITE);
        Bishop WhiteBishop = new Bishop("[♗]", ColorEnum.WHITE);
        Queen WhiteQueen = new Queen("[♕]", ColorEnum.WHITE);
        King WhiteKing = new King("[♔]", ColorEnum.WHITE);

        board[7][0] = WhiteRook.getSymbol(); // White Rook
        board[7][1] = WhiteKnight.getSymbol(); // White Knight
        board[7][2] = WhiteBishop.getSymbol(); // White Bishop
        board[7][3] = WhiteQueen.getSymbol(); // White Queen
        board[7][4] = WhiteKing.getSymbol(); // White King
        board[7][5] = WhiteBishop.getSymbol(); // White Bishop
        board[7][6] = WhiteKnight.getSymbol(); // White Knight
        board[7][7] = WhiteRook.getSymbol(); // White Rook

        Pawn WhitePawn = new Pawn("[♙]", ColorEnum.WHITE);

        board[6][0] = WhitePawn.getSymbol(); // White Pawn
        board[6][1] = WhitePawn.getSymbol(); // White Pawn
        board[6][2] = WhitePawn.getSymbol(); // White Pawn
        board[6][3] = WhitePawn.getSymbol(); // White Pawn
        board[6][4] = WhitePawn.getSymbol(); // White Pawn
        board[6][5] = WhitePawn.getSymbol(); // White Pawn
        board[6][6] = WhitePawn.getSymbol(); // White Pawn
        board[6][7] = WhitePawn.getSymbol(); // White Pawn
    }

    public void printChessboard() {
        System.out.print("  a  b  c  d  e  f  g  h\n"); // Column labels
        for (int row = 0; row < 8; row++) {
            System.out.print((8 - row) + " "); // Row labels
            for (int col = 0; col < 8; col++) {
                System.out.print(board[row][col]);
            }
            System.out.println(); // Move to the next row
        }
    }

    public boolean  isValidPawnMove(int currentRow, int currentCol, int newRow, int newCol, boolean isBlackTurn) {
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

    public boolean isValidKnightMove(int currentRow, int currentCol, int newRow, int newCol) {
        if (currentRow < 0 || currentRow >= 8 || currentCol < 0 || currentCol >= 8 ||
                newRow < 0 || newRow >= 8 || newCol < 0 || newCol >= 8) {
            return false;
        }

        int rowDiff = Math.abs(newRow - currentRow);
        int colDiff = Math.abs(newCol - currentCol);

        // Check if the move is an L-shape (two squares in one direction and one square in a perpendicular direction)
        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
    }




    public void movePiece(int currentRow, int currentCol, int newRow, int newCol) {
        // Move the piece to the new position
        board[newRow][newCol] = board[currentRow][currentCol];
        board[currentRow][currentCol] = "[  ]"; // Clear the old position
    }

}
