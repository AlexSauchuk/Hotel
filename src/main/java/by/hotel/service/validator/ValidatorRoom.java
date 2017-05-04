package by.hotel.service.validator;

import by.hotel.service.exception.IncorrectRoomNameException;
import by.hotel.service.exception.IncorrectRoomPathException;
import by.hotel.service.exception.IncorrectRoomPhoneNumberException;

import java.util.Map;

/**
 * Created by 1 on 18.04.2017.
 */
public class ValidatorRoom extends AbstractValidator {
    public boolean validate(Map<String, String[]> data) throws IncorrectRoomNameException, IncorrectRoomPhoneNumberException, IncorrectRoomPathException {
        if (validateNameRoom(data.get("name")[0]) & validatePhone(data.get("phone")[0])  & validatePath(data.get("path")[0])) {
            return true;
        }
        return false;
    }

    private boolean validateNameRoom(String nameRole) throws IncorrectRoomNameException {
        if (nameRole.length() <= 45 & nameRole.length() >= 5) {
            return true;
        }
        throw new IncorrectRoomNameException("Incorrect room name!");
    }

    private boolean validatePhone(String phone) throws IncorrectRoomPhoneNumberException {
        if (phone.length() <= 45 & phone.length() > 5) {
            return true;
        }
        throw new IncorrectRoomPhoneNumberException("Incorrect room phone number!");
    }

    private boolean validatePath(String path) throws IncorrectRoomPathException {
        if (path.length() <= 200 & path.length() > 5) {
            return true;
        }
        throw new IncorrectRoomPathException("Incorrect room path!");
    }
}
