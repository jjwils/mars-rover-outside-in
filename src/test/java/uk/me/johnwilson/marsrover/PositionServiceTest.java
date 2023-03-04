package uk.me.johnwilson.marsrover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionServiceTest {

    private PositionService positionService;
    private Grid grid;

    @BeforeEach
    public void initialise(){
        grid = new Grid(10,10);
        positionService = new PositionService(grid);
    }

    @Test
    public void should_calculate_position_given_commands(){
        positionService.calculate("MMRMMLM");
        assertEquals(new Position(2,3), positionService.position());
    }

    @Test
    public void should_calculate_position_given_commands_wraparound(){
        positionService.calculate("MMMMMMMMMM");
        assertEquals(new Position(0,0), positionService.position());
    }

    @Test
    public void should_calculate_position_given_no_commands(){
        assertEquals(new Position(0,0), positionService.position());
    }

    @Test
    public void should_calculate_north_direction_given_commands(){
        positionService.calculate("MMRMMLM");
        assertEquals('N', positionService.direction());
    }

    @Test
    public void should_calculate_west_direction_given_commands(){
        positionService.calculate("RLL");
        assertEquals('W', positionService.direction());
    }

    @Test
    public void should_calculate_east_direction_given_commands(){
        positionService.calculate("RLLRR");
        assertEquals('E', positionService.direction());
    }

    @Test
    public void should_calculate_south_direction_given_commands(){
        positionService.calculate("RLLRRR");
        assertEquals('S', positionService.direction());
    }

    @Test
    public void should_calculate_north_direction_given_no_commands(){
        assertEquals('N', positionService.direction());
    }

    @Test
    public void should_calculate_position_given_obstacle(){
        grid.setObstacle(0,3);
        positionService.calculate("MMMM");
        assertEquals(new Position(0,2), positionService.position());
    }

}