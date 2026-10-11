package dev.chearcode.battleship.unit;

public class Ship implements Unit {
    private Section[] body;

    public Ship(int length) {
        initBody(length);
    }

    private void initBody(int length) {
        body = new Section[length];
        for (int i = 0; i < length; i++) {
            body[i] = new Section();
        }
    }

    public void hit(int sectionIndex) {
        body[sectionIndex].hit();
    }

    public boolean isHit(int sectionIndex) {
        return body[sectionIndex].isHit();
    }

    public boolean isSunk() {
        for (Section section : body) {
            if (!section.isHit()) {
                return false;
            }
        }
        return true;
    }

    public int length() {
        return body.length;
    }
}
