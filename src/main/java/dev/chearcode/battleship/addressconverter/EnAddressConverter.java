package dev.chearcode.battleship.addressconverter;

import dev.chearcode.battleship.board.Coordinates;

public class EnAddressConverter implements AddressConverter {
    private static final int FIRST_ROW_ADDRESS = 1;
    private static final char FIRST_COLUMN_ADDRESS = 'A';

    @Override
    public Coordinates toCoordinates(String address) {
        char columnAddress = address.charAt(0);

        if (columnAddress < FIRST_COLUMN_ADDRESS) {
            throw new IllegalArgumentException("Incorrect column address: " + columnAddress);
        }

        String rowAddress = address.substring(1);
        if (Integer.parseInt(rowAddress) < FIRST_ROW_ADDRESS) {
            throw new IllegalArgumentException("Incorrect row address: " + rowAddress);
        }

        int y = Integer.parseInt(rowAddress) - FIRST_ROW_ADDRESS;

        int x = columnAddress - FIRST_COLUMN_ADDRESS;

        return new Coordinates(x, y);

    }

    @Override
    public String toAddress(Coordinates coordinates) {
        String columnAddress = (char) (coordinates.x() + FIRST_COLUMN_ADDRESS) + "";
        String rowAddress = coordinates.y() + FIRST_ROW_ADDRESS + "";
        return columnAddress + rowAddress;
    }
}
