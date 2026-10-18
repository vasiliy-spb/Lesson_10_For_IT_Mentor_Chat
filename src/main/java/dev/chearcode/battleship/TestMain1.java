package dev.chearcode.battleship;

import dev.chearcode.battleship.board.Board;
import dev.chearcode.battleship.board.Coordinates;
import dev.chearcode.battleship.renderer.BoardRenderer;
import dev.chearcode.battleship.renderer.NormalBoardRenderer;
import dev.chearcode.battleship.renderer.OpponentBoardRenderer;
import dev.chearcode.battleship.unit.*;

public class TestMain1 {
    public static void main(String[] args) {
        System.out.println("Капитан на мостике!");

        BoardRenderer renderer = new NormalBoardRenderer();
        BoardRenderer opponentBoardRenderer = new OpponentBoardRenderer();

        Board board = new Board();

        Ship hittedShip = new Cruiser();
        Coordinates hittedShipHead = new Coordinates(2, 5);
        hittedShip.hit(1);
        board.put(hittedShip, hittedShipHead, Board.Direction.VERTICAL);

        Ship sunkShip = new Destroyer();
        Coordinates sunkShipHead = new Coordinates(0, 9);
        board.put(sunkShip, sunkShipHead, Board.Direction.HORIZONTAL);
        sunkShip.hit(0);
        sunkShip.hit(1);

        Ship ship = new Battleship();
        Coordinates head = new Coordinates(0, 0);
        board.put(ship, head, Board.Direction.VERTICAL);

        board.put(new Miss(), new Coordinates(8, 3));

        renderer.render(board);
        System.out.println();
        opponentBoardRenderer.render(board);

    }
}
