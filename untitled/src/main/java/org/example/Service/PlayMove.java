package org.example.Service;

import org.example.Entities.ColorEnum;
import org.example.board.ChessGame;

import java.util.Scanner;

public class PlayMove {

    public void play() {

        boolean isBlackTurn = true;
        Scanner scanner = new Scanner(System.in);
        ChessGame chessGame = new ChessGame();

        while (true) {
            chessGame.printChessboard();

            String currentPlayer = chessGame.isBlackTurn ? "Black" : "White";
            System.out.println(currentPlayer + "'s turn.");

            System.out.println("Enter the current position (e.g., 'b7'): ");
            String currentPosition = scanner.next();
            System.out.println("Enter the new position (e.g., 'b5'): ");
            String newPosition = scanner.next();

            int currentRow = 8 - (currentPosition.charAt(1) - '0');
            int currentCol = currentPosition.charAt(0) - 'a';
            int newRow = 8 - (newPosition.charAt(1) - '0');
            int newCol = newPosition.charAt(0) - 'a';

            // Check if the move is valid for a pawn, knight, rook, bishop, or queen
            boolean isValidMove = false;

            if (chessGame.board[currentRow][currentCol].equals("[♟]") || chessGame.board[currentRow][currentCol].equals("[♙]")) {
                isValidMove = true;
            } else if (chessGame.board[currentRow][currentCol].equals("[♞]") || chessGame.board[currentRow][currentCol].equals("[♘]")) {
                isValidMove = chessGame.isValidKnightMove(currentRow, currentCol, newRow, newCol);
            } else if (chessGame.board[currentRow][currentCol].equals("[♜]") || chessGame.board[currentRow][currentCol].equals("[♖]")) {
                isValidMove = chessGame.isValidRookMove(currentRow, currentCol, newRow, newCol);
            } else if (chessGame.board[currentRow][currentCol].equals("[♝]") || chessGame.board[currentRow][currentCol].equals("[♗]")) {
                isValidMove = chessGame.isValidBishopMove(currentRow, currentCol, newRow, newCol);
            } else if (chessGame.board[currentRow][currentCol].equals("[♛]") || chessGame.board[currentRow][currentCol].equals("[♕]")) {
                isValidMove = chessGame.isValidQueenMove(currentRow, currentCol, newRow, newCol);
            }

            if (isValidMove) {
                // Move the piece
                chessGame.movePiece(currentRow, currentCol, newRow, newCol);
                // Switch players' turns
                chessGame.isBlackTurn = !chessGame.isBlackTurn;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }
}
