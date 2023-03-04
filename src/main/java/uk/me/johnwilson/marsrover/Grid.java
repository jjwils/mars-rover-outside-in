package uk.me.johnwilson.marsrover;

import java.util.ArrayList;
import java.util.List;

public class Grid {
   private Position position;
    private List obstacleList = new ArrayList();

    public Grid(int x, int y) {
       position = new Position(x,y);
    }


    public void setObstacle(int obstacleX, int obstacleY) {
        Position obstacle = new Position(obstacleX,obstacleY);
       if (obstacleX<= position.x() && obstacleY <= position.y()  && !obstacleList.contains(obstacle)){
           obstacleList.add(obstacle);
       }
    }

    public int obstacleCount() {
        return obstacleList.size();
    }

    public List obstacles() {
        return obstacleList;
    }


    public Position position() {
        return position;
    }
}
