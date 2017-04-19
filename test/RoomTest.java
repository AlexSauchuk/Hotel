import by.hotel.service.exception.IncorrectDiscountNameException;
import by.hotel.service.exception.IncorrectRoomNameException;
import by.hotel.service.exception.IncorrectRoomPhoneNumberException;
import by.hotel.service.validator.ValidatorRoom;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1 on 19.04.2017.
 */
public class RoomTest {
    String[][] arrOfRoomData = new String[2][1];
    Map<String, String[]> params = new HashMap<String, String[]>();
    ValidatorRoom validatorRoom = new ValidatorRoom();
    Boolean expected = new Boolean(false);
    Boolean actual = new Boolean(false);

    @Before
    public void setUp() {
        arrOfRoomData[0][0] = "RoomName";
        arrOfRoomData[1][0] = "375291790746";
        params.put("name", arrOfRoomData[0]);
        params.put("phone", arrOfRoomData[1]);
    }

    @Test(expected = IncorrectRoomNameException.class)
    public void wrongRoomNameTest() throws IncorrectRoomNameException, IncorrectRoomPhoneNumberException {
        arrOfRoomData[0][0] = "No";
        params.put("name", arrOfRoomData[0]);
        validatorRoom.validate(params);
    }

    @Test(expected = IncorrectRoomPhoneNumberException.class)
    public void wrongRoomPhoneTest() throws IncorrectRoomPhoneNumberException, IncorrectRoomNameException {
        arrOfRoomData[1][0] = "23";
        params.put("phone", arrOfRoomData[1]);
        validatorRoom.validate(params);
    }

    @Test
    public void rightRoomDataTest() throws IncorrectDiscountNameException, IncorrectRoomPhoneNumberException, IncorrectRoomNameException {
        expected = true;
        actual = validatorRoom.validate(params);
        Assert.assertEquals(expected, actual);
    }
}
