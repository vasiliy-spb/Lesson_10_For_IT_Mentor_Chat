package dev.chearcode.battleship.player;

import dev.chearcode.battleship.board.Board;

public abstract class Player {
    private final String name;
    private final Board board;

    public Player(String name, Board board) {
        this.name = name;
        this.board = board;
    }

    public String getName() {
        return name;
    }

    public Board getBoard() {
        return board;
    }
}
