import by.hotel.service.exception.IncorrectDiscountNameException;
import by.hotel.service.validator.ValidatorDiscount;
import by.hotel.service.validator.ValidatorUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1 on 19.04.2017.
 */
public class DiscountTest {
    String[][] arrOfDiscountData = new String[1][1];
    Map<String, String[]> params = new HashMap<String, String[]>();
    ValidatorDiscount validatorDiscount = new ValidatorDiscount();
    Boolean expected = new Boolean(false);
    Boolean actual = new Boolean(false);

    @Before
    public void setUp() {
        arrOfDiscountData[0][0] = "DiscountName";
        params.put("name", arrOfDiscountData[0]);
    }

    @Test(expected = IncorrectDiscountNameException.class)
    public void wrongDiscountNameTest() throws IncorrectDiscountNameException{
        arrOfDiscountData[0][0] = "No";
        params.put("name", arrOfDiscountData[0]);
        validatorDiscount.validate(params);
    }

    @Test
    public void rightDiscountDataTest() throws IncorrectDiscountNameException {
        expected = true;
        actual = validatorDiscount.validate(params);
        Assert.assertEquals(expected, actual);
    }
}
