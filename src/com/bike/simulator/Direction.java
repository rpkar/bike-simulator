package com.bike.simulator;

import java.util.HashMap;
import java.util.Map;

public enum Direction {

    NORTH(0),
    EAST(1),
    SOUTH(2),
    WEST(3);

    private static Map directionMap = new HashMap<>();
    private int directionIndex;

    Direction(int directionIndex) {
        this.directionIndex = directionIndex;
    }

    static {
        for (Direction direction : Direction.values()) {
            directionMap.put(direction.directionIndex,direction);
        }
    }

    public static Direction valueOf(int directionIndex) {
        return (Direction) directionMap.get(directionIndex);
    }

    public Direction leftDirection() {
        return rotate(-1);
    }

    public Direction rightDirection() {
        return rotate(1);
    }

    private Direction rotate(int step) {

        int newDirectionIndex;

        if ((this.directionIndex + step) < 0) {
            newDirectionIndex = directionMap.size() - 1;
        } else {
            newDirectionIndex = (this.directionIndex + step) % directionMap.size();
        }

        return Direction.valueOf(newDirectionIndex);
    }
}