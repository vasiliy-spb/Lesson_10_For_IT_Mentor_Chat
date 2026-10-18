package dev.chearcode.battleship.dialog;

import java.util.Scanner;

public class EmptyDialog implements Dialog<String> {
    private final String title;
    private final Scanner scanner;

    public EmptyDialog(String title) {
        this.title = title;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String input() {
        System.out.println(title);
        scanner.nextLine();
        return "";
    }
}
