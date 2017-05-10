package by.hotel.service.validator;

import by.hotel.service.exception.*;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUser extends AbstractValidator {
    public boolean validate(Map<String, String[]> data) throws IncorrectUserNameException, IncorrectPassportNumberException, IncorrectPasswordException, IncorrectLoginException, IncorrectMobilePhoneException, IncorrectUserSurnameException,IncorrectUserEmailException {

        if (validatePassportNumber(data.get("passportNumber")[0])
                & validateUserName(data.get("name")[0])
                & validateUserSurName(data.get("surname")[0])
                & validateMobilePhone(data.get("mobilePhone")[0])
                & validatePassword(data.get("password")[0])
                & validateLogin(data.get("login")[0])
                & validateEmail(data.get("email")[0])) {
            return true;
        }
        return false;
    }

    private boolean validatePassportNumber(String passportNumber) throws IncorrectPassportNumberException {
        if (passportNumber.length() < 15 & passportNumber.length() > 5) {
            return true;
        }
        throw new IncorrectPassportNumberException("Incorrect passport number!");
    }

    private boolean validateUserName(String userName) throws IncorrectUserNameException {
        if (userName.length() > 3 & userName.length() < 45) {
            return true;
        }
        throw new IncorrectUserNameException("Incorrect user name!");
    }

    private boolean validateUserSurName(String userSurName) throws IncorrectUserSurnameException {
        if (userSurName.length() < 45 & userSurName.length() > 3) {
            return true;
        }
        throw new IncorrectUserSurnameException("Incorrect user surname!");
    }

    private boolean validateMobilePhone(String mobilePhone) throws IncorrectMobilePhoneException {
        if (mobilePhone.length() < 15 & mobilePhone.length() >= 7) {
            return true;
        }
        throw new IncorrectMobilePhoneException("Incorrect mobile phone!");
    }

    private boolean validatePassword(String password) throws IncorrectPasswordException {
        if (password.length() >= 8){
            return true;
        }
        throw new IncorrectPasswordException("Incorrect password!");
    }

    private boolean validateLogin(String login) throws IncorrectLoginException {
        if (login.length() > 5 & login.length() < 50) {
            return true;
        }
        throw new IncorrectLoginException("Incorrect login!");
    }
    private boolean validateEmail(String email) throws IncorrectUserEmailException {
        Pattern p = Pattern.compile("^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$");
        Matcher m = p.matcher(email);
        if (m.matches()){
            return true;
        }
        throw new IncorrectUserEmailException("Incorrect email!");
    }

}
