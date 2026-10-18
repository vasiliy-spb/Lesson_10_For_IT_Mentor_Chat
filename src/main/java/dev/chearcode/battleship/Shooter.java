package dev.chearcode.battleship;

import dev.chearcode.battleship.board.Board;
import dev.chearcode.battleship.board.BoardUtils;
import dev.chearcode.battleship.board.Coordinates;
import dev.chearcode.battleship.unit.Miss;
import dev.chearcode.battleship.unit.Ship;
import dev.chearcode.battleship.unit.Unit;

public class Shooter {
    public Result shoot(Board board, Coordinates coordinates) {
        if (board.isEmpty(coordinates)) {
            board.put(new Miss(), coordinates);
            return Result.MISS;
        }

        Unit unit = board.get(coordinates);
        if (unit instanceof Miss) {
            return Result.REPEAT_MISS;
        }

        if (unit instanceof Ship ship) {
            int shipSectionIndex = BoardUtils.getShipSectionIndex(board, ship, coordinates);
            if (ship.isHit(shipSectionIndex)) {
                return Result.REPEAT_HIT;
            }
            ship.hit(shipSectionIndex);
            if (ship.isSunk()) {
                return Result.SUNK;
            }
            return Result.HIT;
        }

        throw new IllegalArgumentException("Unknown unit: " + unit);
    }

    public enum Result {
        HIT,
        MISS,
        SUNK,
        REPEAT_HIT,
        REPEAT_MISS;
    }
}
