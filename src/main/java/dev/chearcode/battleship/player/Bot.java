package dev.chearcode.battleship.player;

import dev.chearcode.battleship.board.Board;
import dev.chearcode.battleship.board.BoardUtils;
import dev.chearcode.battleship.board.Coordinates;
import dev.chearcode.battleship.unit.Ship;
import dev.chearcode.battleship.unit.Unit;

import java.util.Random;

public class Bot extends Player {
    private static final Random RANDOM = new Random();

    public Bot(String name, Board board) {
        super(name, board);
    }

    public Coordinates getHitCoordinates(Board opponentBoard) {
        while (true) {
            int x = RANDOM.nextInt(0, opponentBoard.getSize());
            int y = RANDOM.nextInt(0, opponentBoard.getSize());
            Coordinates coordinates = new Coordinates(x, y);
            if (opponentBoard.isEmpty(coordinates)) {
                return coordinates;
            }
            Unit unit = opponentBoard.get(coordinates);
            if (unit instanceof Ship ship) {
                int shipSectionIndex = BoardUtils.getShipSectionIndex(opponentBoard, ship, coordinates);
                if (!ship.isHit(shipSectionIndex)) {
                    return coordinates;
                }
            }
        }
    }
}
