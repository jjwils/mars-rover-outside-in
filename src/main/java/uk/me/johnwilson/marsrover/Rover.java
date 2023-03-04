package uk.me.johnwilson.marsrover;

public class Rover {
    private PositionService positionService;
    private PositionPrinter positionPrinter;

    public Rover(PositionService positionService, PositionPrinter positionPrinter) {

        this.positionService = positionService;
        this.positionPrinter = positionPrinter;
    }

    public void move(String commands) {
        positionService.calculate(commands);
    }

    public void printPosition() {
        positionPrinter.print(positionService.position(), positionService.direction(), positionService.hitObstacle());
   }
}
