package io.github.unongmilkumk.Scissors;

public record Coordinate(int row, int column) {

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
