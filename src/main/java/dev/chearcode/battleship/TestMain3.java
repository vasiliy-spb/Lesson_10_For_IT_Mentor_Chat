package dev.chearcode.battleship;

import dev.chearcode.battleship.board.Coordinates;
import dev.chearcode.battleship.dialog.CoordinatesDialog;
import dev.chearcode.battleship.dialog.Dialog;

public class TestMain3 {
    public static void main(String[] args) {
        Dialog<Coordinates> coordinatesDialog = new CoordinatesDialog("Введите координаты:", "Неправильный ввод");
        while (true) {
            Coordinates coordinates = coordinatesDialog.input();
            System.out.println("coordinates = " + coordinates);
        }
    }
}
