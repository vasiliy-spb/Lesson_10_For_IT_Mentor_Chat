package dev.chearcode.battleship;

import dev.chearcode.battleship.addressconverter.AddressConverter;
import dev.chearcode.battleship.addressconverter.EnAddressConverter;
import dev.chearcode.battleship.addressconverter.RuAddressConverter;
import dev.chearcode.battleship.board.Coordinates;
import dev.chearcode.battleship.dialog.CoordinatesDialog;
import dev.chearcode.battleship.dialog.Dialog;

public class TestMain3 {
    public static void main(String[] args) {
        AddressConverter addressConverter = new RuAddressConverter();
        Dialog<Coordinates> coordinatesDialog = new CoordinatesDialog("Введите координаты:", "Неправильный ввод", addressConverter::toCoordinates);
        while (true) {
            Coordinates coordinates = coordinatesDialog.input();
            System.out.println("coordinates = " + coordinates);
        }
    }
}
