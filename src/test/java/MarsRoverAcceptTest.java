import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.me.johnwilson.marsrover.*;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MarsRoverAcceptTest {

    @Mock Console console;

    Rover rover;
    private PositionService positionService;
    private PositionPrinter positionPrinter;
    private Grid grid;

    @BeforeEach
    void initialise(){
        grid = new Grid(10,10);
        positionService = new PositionService(grid);
        positionPrinter = new PositionPrinter(console);
        rover = new Rover(positionService, positionPrinter);
    }

    @Test
    void given_directions_print_final_position() {

      rover.move("MMRMMLM");
      rover.printPosition();
      verify(console).printLocation("2:3:N");

  }

    @Test
    void given_directions_print_final_position_wraparound() {

        rover.move("MMMMMMMMMM");
        rover.printPosition();
        verify(console).printLocation("0:0:N");

    }

    @Test
    void given_directions_print_obstacle() {
        grid.setObstacle(0,3);
        rover.move("MMMM");
        rover.printPosition();
        verify(console).printLocation("O:0:2:N");

    }
}
