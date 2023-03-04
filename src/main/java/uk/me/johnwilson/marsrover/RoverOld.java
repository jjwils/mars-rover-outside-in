package uk.me.johnwilson.marsrover;

public class RoverOld {

    private int directionIndex = 0;
    private String[] directions = {"N", "E", "S", "W"};


    public void move(String turn) {
        if (turn == "R"){
            directionIndex++;
            if (directionIndex == 4){
                directionIndex = 0;
            }
        }else if (turn == "L"){
            directionIndex--;
            if (directionIndex == -1){
                directionIndex = 3;
            }
        }
    }

    public String direction() {
        return directions[directionIndex];
    }


    public void printPosition() {
    }
}
