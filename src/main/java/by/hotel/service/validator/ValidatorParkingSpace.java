package by.hotel.service.validator;

import java.util.Map;

public class ValidatorParkingSpace extends AbstractValidator{
    public boolean validate(Map<String, String[]> data) {
        if (validateReserved(data.get("isReserved")[0]) & validateReserved(data.get("level")[0])){
            return true;
        }
        return false;
    }

    private boolean validateLevel(String level) {
        if(Integer.parseInt(level) < 1){
            return true;
        }
        return false;
    }

    private boolean validateReserved(String reserved) {
        if(Integer.parseInt(reserved) == 0 | Integer.parseInt(reserved) == 1){
            return true;
        }
        return false;
    }
}
