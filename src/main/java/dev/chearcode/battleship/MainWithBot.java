package dev.chearcode.battleship;

import dev.chearcode.battleship.board.Board;
import dev.chearcode.battleship.factory.FirstBoardFactory;
import dev.chearcode.battleship.factory.SecondBoardFactory;
import dev.chearcode.battleship.player.Bot;
import dev.chearcode.battleship.player.Player;
import dev.chearcode.battleship.player.RealPlayer;

public class MainWithBot {
    public static void main(String[] args) {
        Board firstBoard = new FirstBoardFactory().get();
        Board secondBoard = new SecondBoardFactory().get();

        Player firstPlayer = new RealPlayer("Игрок 1", firstBoard);
        Player secondPlayer = new Bot("Bot 3.5", secondBoard);
        Game game = new Game(firstPlayer, secondPlayer);

        game.start();

    }
}
