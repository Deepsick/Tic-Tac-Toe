package com.deepsick;

import com.deepsick.controllers.FieldController;
import com.deepsick.controllers.GameController;
import com.deepsick.controllers.TurnController;
import com.deepsick.models.Field;
import com.deepsick.views.Console;

public class Main {
    public static void main(String[] args) {
        Field field = new Field(3);
        FieldController fieldController = new FieldController(field);
        TurnController turnController = new TurnController();

        GameController gameController = new GameController(fieldController, turnController);
        gameController.start();
    }
}
