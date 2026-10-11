package dev.chearcode.battleship;

import dev.chearcode.battleship.board.Board;
import dev.chearcode.battleship.board.Coordinates;
import dev.chearcode.battleship.unit.Ship;

import java.util.List;

public final class BoardUtils {
    private BoardUtils() {
    }

    public static int getShipSectionIndex(Board board, Ship ship, Coordinates coordinates) {
        List<Coordinates> allCoordinates = board.getAllCoordinates(ship);
        int sectionIndex = -1;
        for (int i = 0; i < allCoordinates.size(); i++) {
            if (allCoordinates.get(i).equals(coordinates)) {
                sectionIndex = i;
                break;
            }
        }

        if (sectionIndex < 0) {
            throw new IllegalArgumentException("Section index not found for: " + ship);
        }

        return sectionIndex;
    }
}
