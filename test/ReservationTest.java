import by.hotel.service.exception.IncorrectCostException;
import by.hotel.service.exception.IncorrectDateException;
import by.hotel.service.validator.ValidatorParkingSpace;
import by.hotel.service.validator.ValidatorReservation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1 on 19.04.2017.
 */
public class ReservationTest {
    String[][] arrOfReservationData = new String[3][1];
    Map<String, String[]> params = new HashMap<String, String[]>();
    ValidatorReservation validatorReservation = new ValidatorReservation();
    Boolean expected = new Boolean(false);
    Boolean actual = new Boolean(false);

    @Before
    public void setUp() {
        arrOfReservationData[0][0] = "23.12.2012";
        arrOfReservationData[1][0] = "26.12.2012";
        arrOfReservationData[2][0] = "100";
        params.put("dateIn", arrOfReservationData[0]);
        params.put("dateOut", arrOfReservationData[1]);
        params.put("costAdditionalServices", arrOfReservationData[2]);
    }

    @Test(expected = IncorrectDateException.class)
    public void wrongDateInTest() throws IncorrectDateException, IncorrectCostException {
        arrOfReservationData[0][0] = "23-12.2012";
        params.put("dateIn", arrOfReservationData[0]);
        validatorReservation.validate(params);
    }

    @Test(expected = IncorrectDateException.class)
    public void wrongDateOutTest() throws IncorrectDateException, IncorrectCostException {
        arrOfReservationData[1][0] = "No";
        params.put("dateOut", arrOfReservationData[1]);
        validatorReservation.validate(params);
    }

    @Test(expected = NumberFormatException.class)
    public void wrongCostAdditionalServicesTest() throws IncorrectDateException, IncorrectCostException {
        arrOfReservationData[2][0] = "No";
        params.put("costAdditionalServices", arrOfReservationData[2]);
        validatorReservation.validate(params);
    }

    @Test(expected = IncorrectCostException.class)
    public void negativeCostAdditionalServicesTest() throws IncorrectDateException, IncorrectCostException {
        arrOfReservationData[2][0] = "-1";
        params.put("costAdditionalServices", arrOfReservationData[2]);
        validatorReservation.validate(params);
    }

    @Test
    public void rightReservationDataTest() throws IncorrectDateException, IncorrectCostException {
        expected = true;
        actual = validatorReservation.validate(params);
        Assert.assertEquals(expected, actual);
    }
}
