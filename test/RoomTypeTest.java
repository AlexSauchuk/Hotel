import by.hotel.service.exception.*;
import by.hotel.service.validator.ValidatorDiscount;
import by.hotel.service.validator.ValidatorRoom;
import by.hotel.service.validator.ValidatorRoomType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1 on 19.04.2017.
 */
public class RoomTypeTest {
    String[][] arrOfRoomTypeData = new String[7][1];
    Map<String, String[]> params = new HashMap<String, String[]>();
    ValidatorRoomType validatorDiscount = new ValidatorRoomType();
    Boolean expected = new Boolean(false);
    Boolean actual = new Boolean(false);

    @Before
    public void setUp() {
        arrOfRoomTypeData[0][0] = "rooms_count";
        arrOfRoomTypeData[1][0] = "beds_count";
        arrOfRoomTypeData[2][0] = "bathrooms_count";
        arrOfRoomTypeData[3][0] = "rooms_count";
        arrOfRoomTypeData[4][0] = "size";
        arrOfRoomTypeData[5][0] = "additional_info";
        arrOfRoomTypeData[6][0] = "cost_per_day";
        params.put("name", arrOfRoomTypeData[0]);
        params.put("name", arrOfRoomTypeData[1]);
        params.put("name", arrOfRoomTypeData[2]);
        params.put("name", arrOfRoomTypeData[3]);
        params.put("name", arrOfRoomTypeData[4]);
        params.put("name", arrOfRoomTypeData[5]);
        params.put("name", arrOfRoomTypeData[6]);
    }

    @Test(expected = IncorrectDiscountNameException.class)
    public void wrongDiscountNameTest() throws IncorrectDiscountNameException, IncorrectRoomsCountException, IncorrectRoomSizeException, IncorrectRoomAdditionalInfoException, IncorrectRoomBedsException, IncorrectRoomBathroomsException, IncorrectCostException {
        arrOfRoomTypeData[0][0] = "No";
        params.put("name", arrOfRoomTypeData[0]);
        validatorDiscount.validate(params);
    }

    @Test
    public void rightDiscountDataTest() throws IncorrectDiscountNameException, IncorrectRoomsCountException, IncorrectRoomSizeException, IncorrectRoomAdditionalInfoException, IncorrectRoomBedsException, IncorrectRoomBathroomsException, IncorrectCostException {
        expected = true;
        actual = validatorDiscount.validate(params);
        Assert.assertEquals(expected, actual);
    }

}
