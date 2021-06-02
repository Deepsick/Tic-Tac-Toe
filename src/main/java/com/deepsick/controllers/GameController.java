package com.deepsick.controllers;

import com.deepsick.models.Cell;
import com.deepsick.models.Position;
import com.deepsick.views.Console;

public class GameController {
    private final FieldController fieldController;
    private final TurnController turnController;

    public GameController(final FieldController fieldController, final TurnController turnController) {
         this.fieldController = fieldController;
         this.turnController = turnController;
    }
    public void start() {
        Console.welcome(this.getFieldController().getField().getSize());
        Console.printField(this.fieldController.getField());
        Cell.CellContent currentPLayer = turnController.chooseFirstPlayer();
        while (true) {
            Position position = turnController.makeTurn();
            boolean isValid = fieldController.validatePosition(position);
            if (!isValid) {
                Console.printError("Field size is " + this.fieldController.getField().getSize() + ". Please, don't go over the limits");
                continue;
            }
            try {
                this.fieldController.isCellEmpty(position);
            } catch (IllegalArgumentException error) {
                Console.printError("This cell is occupied, please, choose the other one");
                Console.printError(error.getMessage());
                continue;
            }
            this.fieldController.getField().updateCell(position, currentPLayer);
            Console.printField(this.getFieldController().getField());
            if (this.getFieldController().hasLine(position)) {
                break;
            }
            currentPLayer = turnController.changePlayer();
        }

        Console.congratulatePlayer(currentPLayer);
        Console.close();
    }

    public FieldController getFieldController() {
        return this.fieldController;
    }
}
