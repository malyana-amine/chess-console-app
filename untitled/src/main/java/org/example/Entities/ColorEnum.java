package org.example.Entities;

public enum ColorEnum {
    BLACK, WHITE;

    // Static method to convert a char to a ColorEnum
    public static ColorEnum fromChar(char c) {
        if (c == 'B' || c == '♟' || c == '♛' || c == '♚' || c == '♝' || c == '♜' || c == '♞') {
            return BLACK;
        } else if (c == 'W' || c == '♙' || c == '♕' || c == '♔' || c == '♗' || c == '♘' || c == '♖') {
            return WHITE;
        } else {
            throw new IllegalArgumentException("Invalid character: " + c);
        }
    }

}
