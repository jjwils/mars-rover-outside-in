package uk.me.johnwilson.marsrover;

import java.util.Objects;

public class Obstacle {
    private int obstacleX;
    private int obstacleY;

    public Obstacle(int obstacleX, int obstacleY) {
        this.obstacleX = obstacleX;
        this.obstacleY = obstacleY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Obstacle obstacle = (Obstacle) o;
        return obstacleX == obstacle.obstacleX && obstacleY == obstacle.obstacleY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(obstacleX, obstacleY);
    }
}
