package com.bike.simulator;

public class Grid {
    int gridRows;
    int gridColumns;

    public Grid(int rows, int columns) {
        this.gridRows = rows;
        this.gridColumns = columns;
    }

    public boolean isValidPoint(Position position) {
        return !(position.getX() > this.gridColumns || position.getX() < 0 || position.getY() > this.gridRows || position.getY() < 0);
    }
}
