package org.example.Entities;

public class Piece {
    protected String symbol;
    protected ColorEnum Color;

    public Piece(String symbol, ColorEnum color) {
        this.symbol = symbol;
        Color = color;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public ColorEnum getColor() {
        return Color;
    }

    public void setColor(ColorEnum color) {
        Color = color;
    }

    public boolean IsValidMove(String[][] board, int currentRow, int currentCol, int newRow, int newCol, boolean isBlackTurn){
        return false;
    }
}
