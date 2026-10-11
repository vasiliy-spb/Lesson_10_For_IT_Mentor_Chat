package dev.chearcode.battleship.unit;

public class Section {
    private boolean isHit;

    public void hit() {
        isHit = true;
    }

    public boolean isHit() {
        return isHit;
    }
}
