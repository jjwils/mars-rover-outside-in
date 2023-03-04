package uk.me.johnwilson.marsrover;

public class PositionPrinter {

    private Console console;

    public PositionPrinter(Console console) {
        this.console = console;
    }

    public void print(Position position, char direction, boolean obstacle){

        if (obstacle) {
            console.printLocation("O:" + position.x() + ":" + position.y() + ":" + direction);

        } else {
            console.printLocation(position.x() +":"+ position.y() + ":" + direction);
        }
    }
}
