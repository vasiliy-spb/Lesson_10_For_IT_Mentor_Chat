package dev.chearcode.battleship.addressconverter;

import dev.chearcode.battleship.board.Coordinates;

public class RuAddressConverter implements AddressConverter {
    private static final int FIRST_ROW_ADDRESS = 1;
    private static final char FIRST_COLUMN_ADDRESS = 'А';
    private static final char IGNORED_LETTER = 'Й';

    @Override
    public Coordinates toCoordinates(String address) {
        char columnAddress = address.charAt(0);

        if (columnAddress == IGNORED_LETTER) {
            throw new IllegalArgumentException("Incorrect column address: " + columnAddress);
        }

        if (columnAddress < FIRST_COLUMN_ADDRESS) {
            throw new IllegalArgumentException("Incorrect column address: " + columnAddress);
        }

        String rowAddress = address.substring(1);
        if (Integer.parseInt(rowAddress) < FIRST_ROW_ADDRESS) {
            throw new IllegalArgumentException("Incorrect row address: " + rowAddress);
        }

        int y = Integer.parseInt(rowAddress) - FIRST_ROW_ADDRESS;

        int x = columnAddress - FIRST_COLUMN_ADDRESS;

        if (columnAddress > IGNORED_LETTER) {
            x--;
        }

        return new Coordinates(x, y);

    }

    @Override
    public String toAddress(Coordinates coordinates) {
        char letter = (char) (coordinates.x() + FIRST_COLUMN_ADDRESS);
        if (letter == IGNORED_LETTER) {
            letter++;
        }
        String columnAddress = letter + "";
        String rowAddress = coordinates.y() + FIRST_ROW_ADDRESS + "";
        return columnAddress + rowAddress;
    }
}
