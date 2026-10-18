package dev.chearcode.battleship;

import dev.chearcode.battleship.board.Board;
import dev.chearcode.battleship.factory.FirstBoardFactory;
import dev.chearcode.battleship.factory.SecondBoardFactory;
import dev.chearcode.battleship.renderer.BoardRenderer;
import dev.chearcode.battleship.renderer.NormalBoardRenderer;
import dev.chearcode.battleship.renderer.OpponentBoardRenderer;

public class TestMain2 {
    public static void main(String[] args) {
        System.out.println("Капитан на мостике!");

        BoardRenderer renderer = new NormalBoardRenderer();
        BoardRenderer opponentBoardRenderer = new OpponentBoardRenderer();

        Board firstBoard = new FirstBoardFactory().get();
        Board secodnBoard = new SecondBoardFactory().get();

        renderer.render(firstBoard);
        renderer.render(secodnBoard);
    }
}
