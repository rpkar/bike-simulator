package com.bike.simulator;

public class Bike {

    private Position position;

    public Bike() {}

    public void setPosition(Position position) {
        this.position = position;
    }

    public void move(Position newPosition) {
        this.position = newPosition;
    }

    public Position getPosition() {
        return this.position;
    }

    public void rotateLeft() {
        this.position.direction = this.position.direction.leftDirection();
    }

    public void rotateRight() {
        this.position.direction = this.position.direction.rightDirection();
    }
}
