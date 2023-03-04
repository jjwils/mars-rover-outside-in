package uk.me.johnwilson.marsrover;

public class MarsRoverApplication {

    public static void main(String[] args) {
        Grid grid = new Grid(10,10);
        grid.setObstacle(0,9);
        Rover rover = new Rover(new PositionService(grid), new PositionPrinter(new Console()));
        rover.move("MMMMMMMMMM");
        rover.printPosition();
    }
}
