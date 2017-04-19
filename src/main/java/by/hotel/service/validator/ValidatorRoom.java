package by.hotel.service.validator;

import java.util.Map;

/**
 * Created by 1 on 18.04.2017.
 */
public class ValidatorRoom extends AbstractValidator {
    public boolean validate(Map<String, String[]> data) {
        if (validateNameRoom(data.get("name")[0]) & validatePhone(data.get("phone")[0])) {
            return true;
        }
        return false;
    }

    private boolean validateNameRoom(String nameRole) {
        if (nameRole.length() > 45) {
            return false;
        }
        return true;
    }

    private boolean validatePhone(String phone) {
        if (phone.length() > 45) {
            return false;
        }
        return true;
    }
}
