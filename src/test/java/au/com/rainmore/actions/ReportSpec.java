package au.com.rainmore.actions;

import au.com.rainmore.BaseSpec;
import au.com.rainmore.domains.Direction;
import au.com.rainmore.domains.Point;
import au.com.rainmore.domains.Robot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReportSpec extends BaseSpec {

    private Report report = new Report();

    @Mock
    private Robot robot;

    @Test
    public void testGetMessage() {
        when(robot.getCurrentPlace()).thenReturn(Optional.empty());
        Assertions.assertEquals("No Place Set", report.getMessage(robot));

        when(robot.getCurrentPlace()).thenReturn(Optional.of(Place.of(Point.of(10, 10), Direction.EAST)));
        Assertions.assertEquals("Output: 10,10,EAST", report.getMessage(robot));
    }

}
