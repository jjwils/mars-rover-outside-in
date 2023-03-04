package uk.me.johnwilson.marsrover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {


    @Test
    public void given_no_obstacles(){

        Grid grid = new Grid(10,10);
        assertEquals(grid.obstacleCount(),0);

    }

    @Test
    public void given_valid_grid_place_obstacle(){

        Grid grid = new Grid(10,10);
        grid.setObstacle(0,3);
        assertEquals(grid.obstacleCount(),1);

    }

    @Test
    public void given_valid_grid_place_many_obstacles(){

        Grid grid = new Grid(10,10);
        grid.setObstacle(0,3);
        grid.setObstacle(1,4);
        assertEquals(grid.obstacleCount(),2);
    }

    @Test
    public void given_duplicate_obstacle_dont_place(){

        Grid grid = new Grid(10,10);
        grid.setObstacle(0,3);
        grid.setObstacle(0,3);
        assertEquals(grid.obstacleCount(),1);
    }

}