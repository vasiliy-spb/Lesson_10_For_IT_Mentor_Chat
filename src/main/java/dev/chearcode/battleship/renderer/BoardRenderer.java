package dev.chearcode.battleship.renderer;

import dev.chearcode.battleship.board.BoardUtils;
import dev.chearcode.battleship.board.Board;
import dev.chearcode.battleship.board.Coordinates;
import dev.chearcode.battleship.unit.Miss;
import dev.chearcode.battleship.unit.Ship;
import dev.chearcode.battleship.unit.Unit;

public abstract class BoardRenderer {
    protected static final String BACKGROUND = "🔹";
    protected static final String MISS = "🔻";
    protected static final String NORMAL_SECTION = "🟩";
    protected static final String HIT_SECTION = "🟧";
    protected static final String SUNK_SHIP = "🟥";

    public void render(Board board) {
        int size = board.getSize();
        printTopAddressLine();
        int numAddress = 1;
        for (int y = 0; y < size; y++) {
            System.out.printf("%2d ", numAddress);
            numAddress++;
            for (int x = 0; x < size; x++) {
                Coordinates current = new Coordinates(x, y);
                String sprite = getSprite(current, board);
                System.out.print(sprite);
            }
            System.out.println();
        }
    }

    // For Windows
//    private void printTopAddressLine(char letter, int count) {
//        System.out.print(" ");
//        for (int x = 0; x < count; x++) {
//            System.out.print("⬩" + letter + "\u2009"); //"\u2009"
//            letter++;
//        }
//        System.out.println();
//    }

    // For Mac os
    private void printTopAddressLine() {
        System.out.print("   A  B C D E F G  H I J");
        System.out.println();
    }

    private String getSprite(Coordinates coordinates, Board board) {
        if (board.isEmpty(coordinates)) {
            return BACKGROUND;
        }

        Unit unit = board.get(coordinates);
        if (unit instanceof Miss) {
            return MISS;
        }
        if (unit instanceof Ship ship) {
            if (ship.isSunk()) {
                return SUNK_SHIP;
            }
            int sectionIndex = BoardUtils.getShipSectionIndex(board, ship, coordinates);
            return ship.isHit(sectionIndex) ? HIT_SECTION : getNormalSectionSprite();
        }

        throw new IllegalArgumentException("Unexpected unit: " + unit);
    }

    protected abstract String getNormalSectionSprite();
}
