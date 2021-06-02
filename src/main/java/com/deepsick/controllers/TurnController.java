package com.deepsick.controllers;

import com.deepsick.models.Cell;
import com.deepsick.models.Position;
import com.deepsick.views.Console;

import java.util.InputMismatchException;
import java.util.Random;

public class TurnController {
    private Cell.CellContent currentPlayer;

    public Cell.CellContent chooseFirstPlayer() {
        int currentPlayerNumber = new Random().nextInt(2);
        currentPlayer = currentPlayerNumber == 0 ? Cell.CellContent.X : Cell.CellContent.O;

        return currentPlayer;
    }

    public Position makeTurn() {
        try {
            int x = Console.getUserCoord("X");
            int y = Console.getUserCoord("Y");
            return new Position(x - 1, y - 1);
        } catch (InputMismatchException error) {
            Console.printError("Please, input a number");
            return this.makeTurn();
        }
    }

    public Cell.CellContent changePlayer() {
        this.currentPlayer = this.currentPlayer == Cell.CellContent.X ? Cell.CellContent.O : Cell.CellContent.X;
        return this.currentPlayer;
    }
}
