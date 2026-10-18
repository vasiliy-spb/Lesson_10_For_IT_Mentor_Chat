package dev.chearcode.battleship.board;

import dev.chearcode.battleship.unit.Miss;
import dev.chearcode.battleship.unit.Ship;
import dev.chearcode.battleship.unit.Unit;

import java.util.*;

public class Board {
    private static final int SIZE = 10;

    private static final Comparator<Coordinates> COMPARATOR = Comparator
            .comparingInt(Coordinates::x)
            .thenComparingInt(Coordinates::y);

    private final Map<Coordinates, Unit> units = new HashMap<>();

    public void put(Miss miss, Coordinates coordinates) {
        validate(coordinates);
        if (units.containsKey(coordinates)) {
            throw new IllegalArgumentException("Coordinate are busy: " + coordinates);
        }
        units.put(coordinates, miss);
    }

    public void put(Ship ship, Coordinates head, Direction direction) {
        Coordinates current = head;
        int dx = direction == Direction.HORIZONTAL ? 1 : 0;
        int dy = direction == Direction.VERTICAL ? 1 : 0;
        for (int i = 0; i < ship.length(); i++) {
            if (!isEmpty(current)) {
                throw new IllegalArgumentException("Coordinate are busy: " + current);
            }
            units.put(current, ship);
            current = new Coordinates(current.x() + dx, current.y() + dy);
        }
    }

    private void validate(Coordinates coordinates) {
        if (coordinates.x() < 0 || coordinates.x() >= SIZE || coordinates.y() < 0 || coordinates.y() >= SIZE) {
            throw new IllegalArgumentException("Coordinates out of bounds");
        }
    }

    public boolean isEmpty(Coordinates coordinates) {
        validate(coordinates);
        return !units.containsKey(coordinates);
    }

    public List<Coordinates> getAllCoordinates(Unit unit) {
        List<Coordinates> allCoordinates = new ArrayList<>();
        for (Coordinates current : units.keySet()) {
            if (units.get(current) == unit) {
                allCoordinates.add(current);
            }
        }

        if (allCoordinates.isEmpty()) {
            throw new IllegalArgumentException("Unit don't exists: " + unit);
        }

        allCoordinates.sort(COMPARATOR);
        return allCoordinates;
    }

    public Unit get(Coordinates coordinates) {
        validate(coordinates);
        Unit unit = units.get(coordinates);
        if (unit == null) {
            throw new IllegalArgumentException("Coordinates are empty: " + coordinates);
        }
        return unit;
    }

    public int getSize() {
        return SIZE;
    }

    public enum Direction {
        HORIZONTAL,
        VERTICAL;
    }

    public Map<Coordinates, Unit> toMap() {
        return Map.copyOf(units);
    }
}
