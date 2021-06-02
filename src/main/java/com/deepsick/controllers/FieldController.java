package com.deepsick.controllers;

import com.deepsick.models.Cell;
import com.deepsick.models.Field;
import com.deepsick.models.Position;

public class FieldController {
    private enum Dimension {
        VERTICAL, HORIZONTAL, CROSSED, CROSSED_REVERSED
    }

    private final Field field;
    public FieldController(final Field field) {
        this.field = field;
        field.fillField();
    }

    public Field getField() {
        return this.field;
    }

    public boolean validatePosition(Position position) {
        int x = position.getX();
        int y = position.getY();
        if (x >= this.field.getSize() || x < 0) {
            return false;
        }

        if (y >= this.field.getSize() || y < 0) {
            return false;
        }

        return true;
    }

    public void isCellEmpty(Position position) throws  IllegalArgumentException {
        if (!this.getField().isCellEmpty(position)) {
            throw new IllegalArgumentException("(" + position.getX() + ", " + position.getY() + ") is taken, please, choose the other one");
        }
    }

    private Position getShiftedPosition(int x, int y, int shift, Dimension dimension) throws IllegalArgumentException {
        switch (dimension) {
            case VERTICAL:
                return new Position(shift, y);
            case HORIZONTAL:
                return new Position(x, shift);
            case CROSSED:
                return new Position(shift, shift);
            case CROSSED_REVERSED:
                return new Position(shift, this.getField().getSize() - 1 - shift);
            default:
                throw new IllegalArgumentException("Please, provide correct dimension. Provided: " + dimension.name());
        }
    }

    private boolean hasLine(Position position, Dimension dimension) {
        int x = position.getX();
        int y = position.getY();
        Cell.CellContent currentFigure = this.getField().getCell(position).getContent();
        for (int i = 0; i < this.getField().getSize(); i++) {
            Position shiftedPosition = this.getShiftedPosition(x, y, i, dimension);
            Cell.CellContent shiftedFigure = this.getField().getCell(shiftedPosition).getContent();
            if (currentFigure != shiftedFigure) {
                return false;
            }
        }

        return true;
    }

    public boolean hasLine(Position position) {
        for (Dimension dimension : Dimension.values()) {
            boolean hasLine = this.hasLine(position, dimension);
            if (hasLine) {
                return true;
            }
        }

        return false;
    }
}
