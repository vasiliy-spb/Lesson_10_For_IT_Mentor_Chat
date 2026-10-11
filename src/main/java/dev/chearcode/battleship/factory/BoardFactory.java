package dev.chearcode.battleship.factory;

import dev.chearcode.battleship.board.Board;

import java.util.function.Supplier;

public interface BoardFactory extends Supplier<Board> {
}
