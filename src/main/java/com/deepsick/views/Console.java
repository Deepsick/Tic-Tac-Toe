package com.deepsick.views;

import com.deepsick.models.Cell;
import com.deepsick.models.Field;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    private static final Scanner scanner = new Scanner(System.in);

    private static String stringifyCell(Cell cell, int sideSize) {
        String content = cell.getContent().getFigure();
        if (cell.isRightEdge(sideSize)) {
            return " " + content + " ";
        }

        return " " + content + " |";
    }

    private static String getSeparator(int sideSize) {
        return "----".repeat(sideSize);
    }

    public static void printField(Field field) {
        Cell[][] cells = field.getCells();
        System.out.println();
        for (int i = 0; i < field.getSize(); i++) {
            Cell[] row = cells[i];
            for (Cell cell : row) {
                System.out.print(Console.stringifyCell(cell, field.getSize()));
            }
            if (i == field.getSize() - 1) {
                break;
            }
            System.out.print("\n");
            System.out.println(Console.getSeparator(field.getSize()));
        }
        System.out.println();
    }

    public static void welcome(int fieldSize) {
        System.out.println("Welcome to Tic Tac Toe game!\n");
        System.out.println("To witn this game you need to align " + fieldSize + " your figures in a row:");
        System.out.println("- vertical");
        System.out.println("- horizontal");
        System.out.println("- or across");
    }


    public static int getUserCoord(String coordType) throws InputMismatchException {
        try {
            System.out.println("Please, insert " + coordType + " coord");
            int coord = scanner.nextInt();

            return coord;
        } catch (InputMismatchException error) {
            scanner.nextLine();
            throw error;
        }
    }

    public static void printError(String message) {
        System.out.println(message);
    }

    public static void congratulatePlayer(Cell.CellContent player) {
        System.out.println("Congratulations! " + player.getFigure() + " won the game");
    }

    public static void close() {
        Console.scanner.close();
    }
}
