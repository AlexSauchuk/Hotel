import by.hotel.service.exception.*;
import by.hotel.service.validator.ValidatorUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1 on 19.04.2017.
 */
public class UserTest {
    String[][] arrOfUserData = new String[7][1];
    Map<String, String[]> params = new HashMap<String, String[]>();
    ValidatorUser validatorUser = new ValidatorUser();
    Boolean expected = new Boolean(false);
    Boolean actual = new Boolean(false);

    @Before
    public void setUp() {
        arrOfUserData[0][0] = "KB2000252";
        arrOfUserData[1][0] = "Igor";
        arrOfUserData[2][0] = "Kozlov";
        arrOfUserData[3][0] = "M";
        arrOfUserData[4][0] = "375291790746";
        arrOfUserData[5][0] = "GoodPassword";
        arrOfUserData[6][0] = "GoodLogin";
        params.put("passportNumber", arrOfUserData[0]);
        params.put("name", arrOfUserData[1]);
        params.put("surname", arrOfUserData[2]);
        params.put("sex", arrOfUserData[3]);
        params.put("mobilePhone", arrOfUserData[4]);
        params.put("password", arrOfUserData[5]);
        params.put("login", arrOfUserData[6]);
    }

    @Test
    public void wrongPassportNumberTest() throws IncorrectSexException, IncorrectUserNameException, IncorrectPassportNumberException, IncorrectLoginException, IncorrectPasswordException, IncorrectMobilePhoneException, IncorrectUserSurnameException {
        arrOfUserData[0][0] = "KB2000252BadPassportNumber";
        params.put("passportNumber", arrOfUserData[0]);
        actual = validatorUser.validate(params);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void wrongNameTest() throws IncorrectSexException, IncorrectUserNameException, IncorrectPassportNumberException, IncorrectLoginException, IncorrectPasswordException, IncorrectMobilePhoneException, IncorrectUserSurnameException {
        arrOfUserData[1][0] = "1";
        params.put("name", arrOfUserData[1]);
        actual = validatorUser.validate(params);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void wrongSurnameTest() throws IncorrectSexException, IncorrectUserNameException, IncorrectPassportNumberException, IncorrectLoginException, IncorrectPasswordException, IncorrectMobilePhoneException, IncorrectUserSurnameException {
        arrOfUserData[2][0] = "1";
        params.put("surname", arrOfUserData[2]);
        actual = validatorUser.validate(params);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void wrongSexTest() throws IncorrectSexException, IncorrectUserNameException, IncorrectPassportNumberException, IncorrectLoginException, IncorrectPasswordException, IncorrectMobilePhoneException, IncorrectUserSurnameException {
        arrOfUserData[3][0] = "MM";
        params.put("sex", arrOfUserData[3]);
        actual = validatorUser.validate(params);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void wrongMobilePhoneTest() throws IncorrectSexException, IncorrectUserNameException, IncorrectPassportNumberException, IncorrectLoginException, IncorrectPasswordException, IncorrectMobilePhoneException, IncorrectUserSurnameException {
        arrOfUserData[4][0] = "bad";
        params.put("mobilePhone", arrOfUserData[4]);
        actual = validatorUser.validate(params);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void wrongPasswordTest() throws IncorrectSexException, IncorrectUserNameException, IncorrectPassportNumberException, IncorrectLoginException, IncorrectPasswordException, IncorrectMobilePhoneException, IncorrectUserSurnameException {
        arrOfUserData[5][0] = "pass";
        params.put("password", arrOfUserData[5]);
        actual = validatorUser.validate(params);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void wrongLoginTest() throws IncorrectSexException, IncorrectUserNameException, IncorrectPassportNumberException, IncorrectLoginException, IncorrectPasswordException, IncorrectMobilePhoneException, IncorrectUserSurnameException {
        arrOfUserData[6][0] = "";
        params.put("login", arrOfUserData[6]);
        actual = validatorUser.validate(params);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void rightUserDataTest() throws IncorrectSexException, IncorrectUserNameException, IncorrectPassportNumberException, IncorrectLoginException, IncorrectPasswordException, IncorrectMobilePhoneException, IncorrectUserSurnameException {
        expected = true;
        actual = validatorUser.validate(params);
        Assert.assertEquals(expected, actual);
    }
}
