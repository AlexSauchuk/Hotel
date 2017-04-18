package by.hotel.service.validator;

import java.util.Map;

/**
 * Created by 1 on 18.04.2017.
 */
public class ValidatorUser extends AbstractValidator {
    public boolean validate(Map<String, String[]> data) {

        if (validatePassportNumber(data.get("passportNumber")[0])
                & validateUserName(data.get("name")[0])
                & validateUserSurName(data.get("surname")[0])
                & validateSex(data.get("sex")[0])
                & validateMobilePhone(data.get("mobilePhone")[0])
                & validatePassword(data.get("password")[0])
                & validateLogin(data.get("login")[0])) {
            return true;
        }
        return false;
    }

    private boolean validatePassportNumber(String passportNumber) {
        if (passportNumber.length() > 10) {
            return false;
        }
        return true;
    }

    private boolean validateUserName(String userName) {
        if (userName.length() > 45 | userName.length() < 3) {
            return false;
        }
        return true;
    }

    private boolean validateUserSurName(String userSurName) {
        if (userSurName.length() > 45 | userSurName.length() < 3) {
            return false;
        }
        return true;
    }

    private boolean validateSex(String sex) {
        if (sex.length() == 1) {
            return true;
        }
        return false;
    }

    private boolean validateMobilePhone(String mobilePhone) {
        if (mobilePhone.length() > 15 | mobilePhone.length() < 7) {
            return false;
        }
        return true;
    }

    private boolean validatePassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        return true;
    }

    private boolean validateLogin(String login) {
        if (login.length() < 1) {
            return false;
        }
        return true;
    }
}
