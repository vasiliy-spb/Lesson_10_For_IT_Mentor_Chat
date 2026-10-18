package dev.chearcode.battleship.factory;

import dev.chearcode.battleship.board.Board;
import dev.chearcode.battleship.board.Coordinates;
import dev.chearcode.battleship.unit.Battleship;
import dev.chearcode.battleship.unit.Cruiser;
import dev.chearcode.battleship.unit.Destroyer;
import dev.chearcode.battleship.unit.Motorboat;

public class FirstBoardFactory implements BoardFactory {

    @Override
    public Board get() {
        Board board = new Board();
        board.put(new Battleship(), new Coordinates(1, 1), Board.Direction.HORIZONTAL);
        board.put(new Cruiser(), new Coordinates(1, 3), Board.Direction.HORIZONTAL);
        board.put(new Cruiser(), new Coordinates(5, 3), Board.Direction.HORIZONTAL);
        board.put(new Destroyer(), new Coordinates(1, 5), Board.Direction.HORIZONTAL);
        board.put(new Destroyer(), new Coordinates(4, 5), Board.Direction.HORIZONTAL);
        board.put(new Destroyer(), new Coordinates(7, 5), Board.Direction.HORIZONTAL);
        board.put(new Motorboat(), new Coordinates(1, 7), Board.Direction.HORIZONTAL);
        board.put(new Motorboat(), new Coordinates(3, 7), Board.Direction.HORIZONTAL);
        board.put(new Motorboat(), new Coordinates(5, 7), Board.Direction.HORIZONTAL);
        board.put(new Motorboat(), new Coordinates(7, 7), Board.Direction.HORIZONTAL);
        return board;
    }
}
