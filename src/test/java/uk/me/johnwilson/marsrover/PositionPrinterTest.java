package uk.me.johnwilson.marsrover;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PositionPrinterTest {

    @Mock
    Console console;

    @Test
    public void print_position_and_direction_with_a_colon(){

        PositionPrinter positionPrinter = new PositionPrinter(console);
        positionPrinter.print(new Position(2,3),'N', false);

        verify(console).printLocation("2:3:N");
    }

    @Test
    public void print_position_and_obstacle(){

        PositionPrinter positionPrinter = new PositionPrinter(console);
        positionPrinter.print(new Position(0,2),'N', true);

        verify(console).printLocation("O:0:2:N");
    }

}