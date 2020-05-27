package com.bike;

import com.bike.simulator.Bike;
import com.bike.simulator.Direction;
import com.bike.simulator.Grid;
import com.bike.simulator.Position;

public class Simulate {

    int commandCounter;
    Grid grid;
    Bike bike;

    enum Commands {
        PLACE,
        FORWARD,
        TURN_LEFT,
        TURN_RIGHT,
        GPS_REPORT
    }

    enum Directions {
        NORTH,
        SOUTH,
        EAST,
        WEST
    }

    public Simulate() {
        commandCounter = 0;
        this.grid = new Grid(7,7);
        this.bike = new Bike();
    }

    public void goTo(String positionParams) {
        int x;
        int y;
        String[] placeParams =  positionParams.split(",");
        x = Integer.parseInt(placeParams[0]);
        y = Integer.parseInt(placeParams[1]);

        Position position = new Position(x, y, Direction.valueOf(placeParams[2]));
        if (grid.isValidPoint(position)) {
            bike.setPosition(position);
        }
    }

    public void move() {
        Position newPoint = bike.getPosition().getNextPoint();
        if (grid.isValidPoint(newPoint)) {
            bike.move(newPoint);
        }
    }

    public String gpsReport() {
        return "(" + bike.getPosition().getX() + "," + bike.getPosition().getY() + "), " + bike.getPosition().getDirection().toString();
    }

    public String ride(String input) {
        String result = "";
        String isValid = validateCommand(input.split(" "));

        if (isValid.equals("true")) {
            Commands command = Commands.valueOf(input.split(" ")[0]);

            switch (command) {
                case PLACE:
                    goTo(input.split(" ")[1]);
                    break;
                case FORWARD:
                    move();
                    break;
                case TURN_LEFT:
                    bike.rotateLeft();
                    break;
                case TURN_RIGHT:
                    bike.rotateRight();
                    break;
                case GPS_REPORT:
                    result = gpsReport();
                    break;
                default:
                    result = "Invalid Command";
            }
        } else {
            result = isValid;
        }
        return result;
    }

    public String validateCommand(String[] parsedInput) {
        String command = parsedInput[0];
        if (commandCounter == 0 && !command.equals(Commands.valueOf("PLACE").toString())) {
            return "Place the bike on the grid first";
        }
        try {
            Commands.valueOf(command);
            ++commandCounter;
        } catch (Exception e) {
            return "Command Not Found";
        }

        if (command.equals(Commands.valueOf("PLACE").toString()) && parsedInput.length < 2) {
            return "Input right parameters for PLACE command";
        }

        if (command.equals(Commands.valueOf("PLACE").toString())) {
            String[] placeParams =  parsedInput[1].split(",");
            try {
                Directions.valueOf(placeParams[2]);
                Integer.parseInt(placeParams[0]);
                Integer.parseInt(placeParams[1]);
            } catch (Exception e) {
                return "Invalid parameter for PLACE command";
            }
        }

        return "true";
    }
}
