import org.junit.jupiter.api.Test;
import uk.me.johnwilson.marsrover.RoverOld;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverTest {

    @Test
    void move_rover_right_360_degrees() {
        RoverOld rover = new RoverOld();
        rover.move("R");
        assertEquals(rover.direction(), "E");

        rover.move("R");
        assertEquals(rover.direction(), "S");

        rover.move("R");
        assertEquals(rover.direction(), "W");

        rover.move("R");
        assertEquals(rover.direction(), "N");






    }

    @Test
    void move_rover_left_360_degrees() {
        RoverOld rover = new RoverOld();
        rover.move("L");
        assertEquals(rover.direction(), "W");

        rover.move("L");
        assertEquals(rover.direction(), "S");

        rover.move("L");
        assertEquals(rover.direction(), "E");

        rover.move("L");
        assertEquals(rover.direction(), "N");


    }

}
