package com.deepsick.models;

public class Cell {
    public enum CellContent {
        EMPTY(" "),
        O("O"),
        X("X");

        final private String figure;
        CellContent(final String figure) {
            this.figure = figure;
        }

        public String getFigure() {
            return figure;
        }
    }

    private final Position position;
    private final CellContent content;
    public Cell(final Position position, final CellContent cellContent) {
        this.position = position;
        this.content = cellContent;
    }

    public Position getPosition() {
        return this.position;
    }

    public CellContent getContent() {
        return this.content;
    }

    public boolean isRightEdge(int sideSize) {
        int y = this.getPosition().getY();
        return y == sideSize - 1;
    }
}
