package dev.chearcode.battleship;

import dev.chearcode.battleship.addressconverter.AddressConverter;
import dev.chearcode.battleship.addressconverter.RuAddressConverter;
import dev.chearcode.battleship.board.Coordinates;
import dev.chearcode.battleship.dialog.CoordinatesDialog;
import dev.chearcode.battleship.dialog.Dialog;

import java.util.List;

public class TestMain4 {
    public static void main(String[] args) {
        AddressConverter addressConverter = new RuAddressConverter();
        List<String > adresses = List.of(
                "А1",
                "А10",
                "В9",
                "И8",
                "К9",
                "Л9"
        );
        for (String adress : adresses) {
            System.out.println("Исходный адрес: " + adress);
            Coordinates coordinates = addressConverter.toCoordinates(adress);
            System.out.println("coordinates = " + coordinates);
            String address = addressConverter.toAddress(coordinates);
            System.out.println("address = " + address);
            System.out.println();
        }
    }
}
