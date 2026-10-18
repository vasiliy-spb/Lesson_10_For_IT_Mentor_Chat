package dev.chearcode.battleship.renderer;

import dev.chearcode.battleship.board.Coordinates;

import java.util.function.Function;

public class NormalBoardRenderer extends BoardRenderer {
    public NormalBoardRenderer(Function<Coordinates, String> mapper) {
        super(mapper);
    }

    @Override
    protected String getNormalSectionSprite() {
        return NORMAL_SECTION;
    }
}
