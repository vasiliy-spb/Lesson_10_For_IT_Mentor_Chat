package dev.chearcode.battleship.dialog;

import dev.chearcode.battleship.board.Coordinates;

import java.util.Scanner;
import java.util.function.Function;

public class CoordinatesDialog implements Dialog<Coordinates> {
    private final String title;
    private final String error;
    private final Scanner scanner;
    private final Function<String, Coordinates> mapper;

    public CoordinatesDialog(String title, String error, Function<String, Coordinates> mapper) {
        this.title = title;
        this.error = error;
        this.mapper = mapper;
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
                return mapper.apply(data);
            } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
                System.out.println(error);
            }
        }
    }
}
