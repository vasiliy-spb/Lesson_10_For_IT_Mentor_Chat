package dev.chearcode.battleship.factory;

import dev.chearcode.battleship.board.Board;
import dev.chearcode.battleship.board.Coordinates;
import dev.chearcode.battleship.unit.Battleship;
import dev.chearcode.battleship.unit.Cruiser;
import dev.chearcode.battleship.unit.Destroyer;
import dev.chearcode.battleship.unit.Motorboat;

public class SecondBoardFactory implements BoardFactory {
    @Override
    public Board get() {
        Board board = new Board();
        board.put(new Battleship(), new Coordinates(1, 1), Board.Direction.VERTICAL);
        board.put(new Cruiser(), new Coordinates(3, 1), Board.Direction.VERTICAL);
        board.put(new Cruiser(), new Coordinates(3, 5), Board.Direction.VERTICAL);
        board.put(new Destroyer(), new Coordinates(5, 1), Board.Direction.VERTICAL);
        board.put(new Destroyer(), new Coordinates(5, 4), Board.Direction.VERTICAL);
        board.put(new Destroyer(), new Coordinates(5, 7), Board.Direction.VERTICAL);
        board.put(new Motorboat(), new Coordinates(7, 1), Board.Direction.VERTICAL);
        board.put(new Motorboat(), new Coordinates(7, 3), Board.Direction.VERTICAL);
        board.put(new Motorboat(), new Coordinates(7, 5), Board.Direction.VERTICAL);
        board.put(new Motorboat(), new Coordinates(7, 7), Board.Direction.VERTICAL);
        return board;
    }
}
