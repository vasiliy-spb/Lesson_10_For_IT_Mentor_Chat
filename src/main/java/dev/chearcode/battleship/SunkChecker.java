package dev.chearcode.battleship;

import dev.chearcode.battleship.board.Board;
import dev.chearcode.battleship.board.Coordinates;
import dev.chearcode.battleship.unit.Ship;
import dev.chearcode.battleship.unit.Unit;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SunkChecker {
    public boolean isAllSunk(Board board) {
        Map<Coordinates, Unit> unitMap = board.toMap();
        Set<Unit> units = new HashSet<>(unitMap.values());
        for (Unit unit : units) {
            if (unit instanceof Ship ship && !ship.isSunk()) {
                return false;
            }
        }
        return true;
    }
}
