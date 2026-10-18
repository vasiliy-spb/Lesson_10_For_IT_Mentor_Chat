package dev.chearcode.battleship.renderer;

import dev.chearcode.battleship.board.Coordinates;

import java.util.function.Function;

public class OpponentBoardRenderer extends BoardRenderer {
    public OpponentBoardRenderer(Function<Coordinates, String> mapper) {
        super(mapper);
    }

    @Override
    protected String getNormalSectionSprite() {
        return BACKGROUND;
    }
}
