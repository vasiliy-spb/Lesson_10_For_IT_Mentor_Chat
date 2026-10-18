package dev.chearcode.battleship.dialog;

import dev.chearcode.battleship.board.Coordinates;

import java.util.Scanner;

public class CoordinatesDialog implements Dialog<Coordinates> {
    private static final int FIRST_ROW_ADDRESS = 1;
    private static final char FIRST_COLUMN_ADDRESS = 'A';
    private final String title;
    private final String error;
    private final Scanner scanner;

    public CoordinatesDialog(String title, String error) {
        this.title = title;
        this.error = error;
        this.scanner = new Scanner(System.in);
    }

    // b2
    // B2
    @Override
    public Coordinates input() {
        System.out.println(title);

        while (true) {
            String data = scanner.nextLine().toUpperCase();
            try {
                return parseCoordinates(data);
            } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
                System.out.println(error);
            }
        }
    }

    // B1
    private Coordinates parseCoordinates(String data) {
        char columnAddress = data.charAt(0);

        if (columnAddress < FIRST_COLUMN_ADDRESS) {
            throw new IllegalArgumentException("Incorrect column address: " + columnAddress);
        }

        String rowAddress = data.substring(1);
        if (Integer.parseInt(rowAddress) < FIRST_ROW_ADDRESS) {
            throw new IllegalArgumentException("Incorrect row address: " + rowAddress);
        }

        int y = Integer.parseInt(rowAddress) - FIRST_ROW_ADDRESS;

        int x = columnAddress - FIRST_COLUMN_ADDRESS;

        return new Coordinates(x, y);
    }
}
