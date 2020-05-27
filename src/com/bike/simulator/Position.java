package com.bike.simulator;

public class Position {
    int x;
    int y;
    Direction direction;

    public Position(Position position) {
        this.x = position.getX();
        this.y = position.getY();
        this.direction = position.getDirection();
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void change(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public Position getNextPoint() {
        Position newPoint = new Position(this);
        switch (this.direction) {
            case NORTH:
                newPoint.change(0, 1);
                break;
            case EAST:
                newPoint.change(1, 0);
                break;
            case SOUTH:
                newPoint.change(0, -1);
                break;
            case WEST:
                newPoint.change(-1, 0);
                break;
        }
        return newPoint;
    }
}
