import by.hotel.service.exception.IncorrectParkingSpaceLevelException;
import by.hotel.service.exception.IncorrectParkingSpaceRecervationException;
import by.hotel.service.validator.ValidatorDiscount;
import by.hotel.service.validator.ValidatorParkingSpace;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1 on 19.04.2017.
 */
public class ParkingSpaceTest {
    String[][] arrOfParkingSpaceData = new String[2][1];
    Map<String, String[]> params = new HashMap<String, String[]>();
    ValidatorParkingSpace validatorParkingSpace = new ValidatorParkingSpace();
    Boolean expected = new Boolean(false);
    Boolean actual = new Boolean(false);

    @Before
    public void setUp() {
        arrOfParkingSpaceData[0][0] = "0";
        arrOfParkingSpaceData[1][0] = "1";
        params.put("level", arrOfParkingSpaceData[0]);
        params.put("isReserved", arrOfParkingSpaceData[0]);
    }

    @Test(expected = NumberFormatException.class)
    public void wrongLevelTest() throws IncorrectParkingSpaceLevelException, IncorrectParkingSpaceRecervationException {
        arrOfParkingSpaceData[0][0] = "No";
        params.put("level", arrOfParkingSpaceData[0]);
        actual = validatorParkingSpace.validate(params);
    }

    @Test(expected = NumberFormatException.class)
    public void wrongReservationTest() throws IncorrectParkingSpaceLevelException, IncorrectParkingSpaceRecervationException {
        arrOfParkingSpaceData[1][0] = "No";
        params.put("isReserved", arrOfParkingSpaceData[1]);
        actual = validatorParkingSpace.validate(params);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void rightParkingSpaceDataTest() throws IncorrectParkingSpaceLevelException, IncorrectParkingSpaceRecervationException {
        expected = true;
        actual = validatorParkingSpace.validate(params);
        Assert.assertEquals(expected, actual);
    }
}
