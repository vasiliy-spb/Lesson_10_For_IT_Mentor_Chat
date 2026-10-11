package dev.chearcode.battleship.factory;

import dev.chearcode.battleship.board.Board;
import dev.chearcode.battleship.board.Coordinates;
import dev.chearcode.battleship.unit.Ship;

public class FirstBoardFactory implements BoardFactory {

    @Override
    public Board get() {
        Board board = new Board();
        board.put(new Ship(4), new Coordinates(1, 1), Board.Direction.HORIZONTAL);
        board.put(new Ship(3), new Coordinates(1, 3), Board.Direction.HORIZONTAL);
        board.put(new Ship(3), new Coordinates(5, 3), Board.Direction.HORIZONTAL);
        board.put(new Ship(2), new Coordinates(1, 5), Board.Direction.HORIZONTAL);
        board.put(new Ship(2), new Coordinates(4, 5), Board.Direction.HORIZONTAL);
        board.put(new Ship(2), new Coordinates(7, 5), Board.Direction.HORIZONTAL);
        board.put(new Ship(1), new Coordinates(1, 7), Board.Direction.HORIZONTAL);
        board.put(new Ship(1), new Coordinates(3, 7), Board.Direction.HORIZONTAL);
        board.put(new Ship(1), new Coordinates(5, 7), Board.Direction.HORIZONTAL);
        board.put(new Ship(1), new Coordinates(7, 7), Board.Direction.HORIZONTAL);
        return board;
    }
}
