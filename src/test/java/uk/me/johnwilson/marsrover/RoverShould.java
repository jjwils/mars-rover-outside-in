package uk.me.johnwilson.marsrover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RoverShould {


    @Mock PositionService positionService;
    private Rover rover;
    @Mock PositionPrinter positionPrinter;

    @BeforeEach
    public void initialise(){
        rover = new Rover(positionService, positionPrinter);
    }

    @Test
    public void calculate_coordinates() {

        rover.move("MMRMMLM");

        verify(positionService).calculate("MMRMMLM");

    }

    @Test
    public void calculate_direction(){
        rover.move("MMRMMLM");

        verify(positionService).calculate("MMRMMLM");


    }

    @Test
    public void print_position(){

        Position position = new Position(2,3);
        char direction = 'W';

        given(positionService.position()).willReturn(position);
        given(positionService.direction()).willReturn('W');

        rover.printPosition();

        verify(positionPrinter).print(position, direction, false);

    }

}