package com.deepsick.models;

public class Field {
    private final int sideSize;
    private final Cell[][] cells;

    public Field(int sideSize) {
        this.sideSize = sideSize;
        cells = new Cell[sideSize][sideSize];
    }

    public void fillField() {
        for (int i = 0; i < this.sideSize; i++) {
            for (int j = 0; j <  this.sideSize; j++) {
                Position position = new Position(i, j);
                cells[i][j] = new Cell(position, Cell.CellContent.EMPTY);
            }
        }
    }

    public Cell updateCell(Position position, Cell.CellContent content) {
        int x = position.getX();
        int y = position.getY();
        this.cells[x][y] = new Cell(position, content);

        return this.cells[x][y];
    }

    public boolean isCellEmpty(Position position) {
        int x = position.getX();
        int y = position.getY();
        return this.cells[x][y].getContent() == Cell.CellContent.EMPTY;
    }

    public Cell getCell(Position position) {
        int x = position.getX();
        int y = position.getY();
        return this.cells[x][y];
    }

    public Cell[][] getCells() {
        return this.cells;
    }

    public int getSize() {
        return this.sideSize;
    }
}
