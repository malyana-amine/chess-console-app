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
            System.out.println(board[newRow][newCol].charAt(1)+"eee"+board[currentRow][currentCol].charAt(1));
            return false; // Destination square has a friendly piece
        }

        if (!(board[currentRow][currentCol].equals("[♟]") || board[currentRow][currentCol].equals("[♙]"))) {

            return false;
        }

        // Determine the direction of movement based on the player's turn
        int direction = isBlackTurn ? 1 : -1;

        // Pawn moves forward
        if (currentCol == newCol && currentRow + direction == newRow && board[newRow][newCol].equals("[ ]")) {
            return true;
        }
        System.out.println(board[newRow][newCol].equals("[ ]"));
        // Pawn moves two squares forward on its first move
        if (currentCol == newCol && currentRow + 2 * direction == newRow && currentRow == (isBlackTurn ? 1 : 6) && board[newRow][newCol].equals("[ ]")) {
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

    public boolean isValidRockMove(){
        // rock logic
        return false;
    }

    public boolean isValidRookMove(int currentRow, int currentCol, int newRow, int newCol) {
        if (currentRow < 0 || currentRow >= 8 || currentCol < 0 || currentCol >= 8 ||
                newRow < 0 || newRow >= 8 || newCol < 0 || newCol >= 8) {
            return false;
        }

        // Rook can move either horizontally (in the same row) or vertically (in the same column)
        if (currentRow == newRow && currentCol != newCol) {
            // Moving horizontally
            int step = (newCol > currentCol) ? 1 : -1;
            for (int col = currentCol + step; col != newCol; col += step) {
                if (!board[currentRow][col].equals("[ ]")) {
                    return false; // There's an obstruction in the path
                }
            }
            return true;
        } else if (currentCol == newCol && currentRow != newRow) {
            // Moving vertically
            int step = (newRow > currentRow) ? 1 : -1;
            for (int row = currentRow + step; row != newRow; row += step) {
                if (!board[row][currentCol].equals("[ ]")) {
                    return false; // There's an obstruction in the path
                }
            }
            return true;
        }

        return false; // Invalid Rook move
    }

    public boolean isValidBishopMove(int currentRow, int currentCol, int newRow, int newCol) {
        if (currentRow < 0 || currentRow >= 8 || currentCol < 0 || currentCol >= 8 ||
                newRow < 0 || newRow >= 8 || newCol < 0 || newCol >= 8) {
            return false;
        }

        // Check if the move is diagonal (same absolute difference in rows and columns)
        int rowDiff = Math.abs(newRow - currentRow);
        int colDiff = Math.abs(newCol - currentCol);

        if (rowDiff == colDiff) {
            // Check if there are no obstructions in the diagonal path
            int rowStep = (newRow > currentRow) ? 1 : -1;
            int colStep = (newCol > currentCol) ? 1 : -1;

            for (int row = currentRow + rowStep, col = currentCol + colStep;
                 row != newRow && col != newCol;
                 row += rowStep, col += colStep) {
                if (!board[row][col].equals("[ ]")) {
                    return false; // There's an obstruction in the diagonal path
                }
            }

            return true;
        }

        return false; // Invalid Bishop move
    }

    public boolean isValidQueenMove(int currentRow, int currentCol, int newRow, int newCol) {
        if (currentRow < 0 || currentRow >= 8 || currentCol < 0 || currentCol >= 8 ||
                newRow < 0 || newRow >= 8 || newCol < 0 || newCol >= 8) {
            return false;
        }

        // Check if the move is a valid Rook move (horizontal or vertical)
        if (isValidRookMove(currentRow, currentCol, newRow, newCol)) {
            return true;
        }

        // Check if the move is a valid Bishop move (diagonal)
        if (isValidBishopMove(currentRow, currentCol, newRow, newCol)) {
            return true;
        }

        return false; // Invalid Queen move
    }
    public boolean isValidMoveForKing(int currentRow, int currentCol, int newRow, int newCol) {
        if (currentRow < 0 || currentRow >= 8 || currentCol < 0 || currentCol >= 8 ||
                newRow < 0 || newRow >= 8 || newCol < 0 || newCol >= 8) {
            return false;
        }

        int rowDiff = Math.abs(newRow - currentRow);
        int colDiff = Math.abs(newCol - currentCol);

        // Check if the move is within one square in any direction (horizontally, vertically, or diagonally)
        return (rowDiff <= 1 && colDiff <= 1);
    }



    public void movePiece(int currentRow, int currentCol, int newRow, int newCol) {
        if (isValidPawnMove(currentRow, currentCol, newRow, newCol, isBlackTurn)) {
            // Move the Pawn to the new position
            board[newRow][newCol] = board[currentRow][currentCol];
            board[currentRow][currentCol] = "[ ]"; // Clear the old position
        } else if (isValidKnightMove(currentRow, currentCol, newRow, newCol)) {
            // Move the Knight to the new position
            board[newRow][newCol] = board[currentRow][currentCol];
            board[currentRow][currentCol] = "[ ]"; // Clear the old position
        } else if (isValidRookMove(currentRow, currentCol, newRow, newCol)) {
            // Move the Rook to the new position
            board[newRow][newCol] = board[currentRow][currentCol];
            board[currentRow][currentCol] = "[ ]"; // Clear the old position
        } else if (isValidBishopMove(currentRow, currentCol, newRow, newCol)) {
            // Move the Bishop to the new position
            board[newRow][newCol] = board[currentRow][currentCol];
            board[currentRow][currentCol] = "[ ]"; // Clear the old position
        } else if (isValidQueenMove(currentRow, currentCol, newRow, newCol)) {
            // Move the Queen to the new position
            board[newRow][newCol] = board[currentRow][currentCol];
            board[currentRow][currentCol] = "[ ]"; // Clear the old position
        } else if (isValidMoveForKing(currentRow, currentCol, newRow, newCol)) {
            // Move the King to the new position
            board[newRow][newCol] = board[currentRow][currentCol];
            board[currentRow][currentCol] = "[ ]"; // Clear the old position
        } else {
            System.out.println("Invalid move. Please try again.");
        }
    }





}
