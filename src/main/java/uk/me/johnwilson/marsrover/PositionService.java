package uk.me.johnwilson.marsrover;

public class PositionService {

    private int directionIndex = 0;
    private char[] directions = {'N', 'E', 'S', 'W'};
    private int x = 0;
    private int y = 0;
    private Grid grid;
    Position currentPosition = new Position(0,0);
    Position previousPosition;
    private boolean hitObstacle = false;

    public PositionService(Grid grid) {

        this.grid = grid;
    }

    public void calculate(String commands) {

        for (int i = 0; i < commands.length(); i++) {

            char command = commands.charAt(i);
            previousPosition = new Position(x,y);
            directionCalc(command);
            positionCalc(command);
            currentPosition = new Position(x,y);

            grid.obstacles().forEach(o -> {
                if (o.equals(currentPosition)){
                    currentPosition = previousPosition;
                    hitObstacle = true;
                }
            });

                if (currentPosition == previousPosition){
                    break;
                }

        }
    }

    private void positionCalc(char command) {
        if (command == 'M') {
            switch (directions[directionIndex]) {
                case 'W':
                    x--;
                    break;
                case 'E':
                    x++;
                    if (x == grid.position().x()) {
                        x = 0;
                    }
                    break;
                case 'N':
                    y++;
                    if (y == grid.position().y()) {
                        y = 0;
                    }
                    break;
                case 'S':
                    y--;
                    break;
            }
        }
    }

    private void directionCalc(char command) {
        if (command == 'R') {
            directionIndex++;
            if (directionIndex == 4) {
                directionIndex = 0;
            }
        } else if (command == 'L') {
            directionIndex--;
            if (directionIndex == -1) {
                directionIndex = 3;
            }
        }
    }


    public Position position() {
        return currentPosition;
    }

    public char direction() {
        return directions[directionIndex];
    }

    public boolean hitObstacle() {
        return hitObstacle;
    }
}
