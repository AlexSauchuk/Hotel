package by.hotel.service.validator;

import by.hotel.service.exception.IncorrectParkingSpaceLevelException;
import by.hotel.service.exception.IncorrectParkingSpaceReservationException;

import java.util.Map;

/**
 * Created by 1 on 18.04.2017.
 */
public class ValidatorParkingSpace extends AbstractValidator {
    public boolean validate(Map<String, String[]> data) throws IncorrectParkingSpaceLevelException, IncorrectParkingSpaceReservationException {
        if (validateReserved(data.get("isReserved")[0]) & validateLevel(data.get("level")[0])) {
            return true;
        }
        return false;
    }

    private boolean validateLevel(String level) throws IncorrectParkingSpaceLevelException {
        if (Integer.parseInt(level) >= 0 & Integer.parseInt(level) <= 5) {
            return true;
        }
        throw new IncorrectParkingSpaceLevelException("Incorrect parking space level!");

    }

    private boolean validateReserved(String reserved) throws IncorrectParkingSpaceReservationException {
        if (Integer.parseInt(reserved) == 0 | Integer.parseInt(reserved) == 1) {
            return true;
        }
        throw new IncorrectParkingSpaceReservationException("Incorrect parking space reservation!");
    }
}
