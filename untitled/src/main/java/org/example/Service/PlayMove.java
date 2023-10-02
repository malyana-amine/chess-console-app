package org.example.Service;

import org.example.board.ChessGame;

import java.util.Scanner;

public class PlayMove {

    public void play() {
        String currentPosition;
        String newPosition;
        boolean isBlackTurn = true;
        Scanner scanner = new Scanner(System.in);
        ChessGame chessGame = new ChessGame();
        
        while (true) {

            chessGame.printChessboard();
            String currentPlayer = isBlackTurn ? "Black" : "White";
            System.out.println(currentPlayer + "'s turn.");

            System.out.println("Enter the current position (e.g., 'b7'): ");
            currentPosition = scanner.next();
            System.out.println("Enter the new position (e.g., 'b5'): ");
            newPosition = scanner.next();

            if (isValidMove(currentPosition, newPosition)) {
                makeMove(currentPosition, newPosition);
                chessGame.printChessboard();
                isBlackTurn = !isBlackTurn; // Switch turns
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    private boolean isValidMove(String currentPosition, String newPosition) {
        // Implement your move validation logic here
        // You can check if the move is valid for the specific piece type (e.g., Pawn, Knight)
        // You may need additional methods or classes for this.
        return true; // Replace with your logic
    }

    private void makeMove(String currentPosition, String newPosition) {
        // Implement the logic to update the board based on the move
        // You can move the piece, capture opponents, and handle promotions, castling, etc.
        // You may need additional methods or classes for this.
    }
}
