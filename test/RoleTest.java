import by.hotel.service.exception.IncorrectDiscountNameException;
import by.hotel.service.exception.IncorrectNameRoleException;
import by.hotel.service.exception.IncorrectRightRoleException;
import by.hotel.service.validator.ValidatorRole;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1 on 19.04.2017.
 */
public class RoleTest {
    String[][] arrOfRoleData = new String[8][1];
    Map<String, String[]> params = new HashMap<String, String[]>();
    ValidatorRole validatorRole = new ValidatorRole();
    Boolean expected = new Boolean(false);
    Boolean actual = new Boolean(false);

    @Before
    public void setUp() {
        arrOfRoleData[0][0] = "Admin";
        arrOfRoleData[1][0] = "1";
        arrOfRoleData[2][0] = "1";
        arrOfRoleData[3][0] = "1";
        arrOfRoleData[4][0] = "1";
        arrOfRoleData[5][0] = "1";
        arrOfRoleData[6][0] = "1";
        arrOfRoleData[7][0] = "1";
        params.put("name_role", arrOfRoleData[0]);
        params.put("update", arrOfRoleData[1]);
        params.put("delete", arrOfRoleData[2]);
        params.put("insert", arrOfRoleData[3]);
        params.put("create", arrOfRoleData[4]);
        params.put("select", arrOfRoleData[5]);
        params.put("drop", arrOfRoleData[6]);
        params.put("grant", arrOfRoleData[7]);
    }

    @Test(expected = IncorrectNameRoleException.class)
    public void wrongRoleNameTest() throws IncorrectNameRoleException, IncorrectRightRoleException {
        arrOfRoleData[0][0] = "No";
        params.put("name_role", arrOfRoleData[0]);
        validatorRole.validate(params);
    }

    @Test(expected = IncorrectRightRoleException.class)
    public void wrongUpdateRightTest() throws IncorrectNameRoleException, IncorrectRightRoleException {
        arrOfRoleData[1][0] = "9";
        params.put("update", arrOfRoleData[1]);
        validatorRole.validate(params);
    }

    @Test(expected = IncorrectRightRoleException.class)
    public void wrongDeleteRightTest() throws IncorrectNameRoleException, IncorrectRightRoleException {
        arrOfRoleData[2][0] = "22";
        params.put("delete", arrOfRoleData[2]);
        validatorRole.validate(params);
    }

    @Test(expected = IncorrectRightRoleException.class)
    public void wrongInsertRightTest() throws IncorrectNameRoleException, IncorrectRightRoleException {
        arrOfRoleData[3][0] = "015";
        params.put("insert", arrOfRoleData[3]);
        validatorRole.validate(params);
    }

    @Test(expected = IncorrectRightRoleException.class)
    public void wrongCreateRightTest() throws IncorrectNameRoleException, IncorrectRightRoleException {
        arrOfRoleData[4][0] = "4";
        params.put("create", arrOfRoleData[4]);
        validatorRole.validate(params);
    }

    @Test(expected = IncorrectRightRoleException.class)
    public void wrongSelectRightTest() throws IncorrectNameRoleException, IncorrectRightRoleException {
        arrOfRoleData[5][0] = "55";
        params.put("select", arrOfRoleData[5]);
        validatorRole.validate(params);
    }

    @Test(expected = IncorrectRightRoleException.class)
    public void wrongDropRightTest() throws IncorrectNameRoleException, IncorrectRightRoleException {
        arrOfRoleData[6][0] = "66";
        params.put("drop", arrOfRoleData[6]);
        validatorRole.validate(params);
    }

    @Test(expected = IncorrectRightRoleException.class)
    public void wrongGrantRightTest() throws IncorrectNameRoleException, IncorrectRightRoleException {
        arrOfRoleData[7][0] = "161";
        params.put("grant", arrOfRoleData[7]);
        validatorRole.validate(params);
    }
    @Test
    public void rightRoleDataTest() throws IncorrectDiscountNameException, IncorrectNameRoleException, IncorrectRightRoleException {
        expected = true;
        actual = validatorRole.validate(params);
        Assert.assertEquals(expected, actual);
    }
}
