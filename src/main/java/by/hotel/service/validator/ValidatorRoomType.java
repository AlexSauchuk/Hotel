package by.hotel.service.validator;

import by.hotel.service.exception.*;

import java.util.Map;

/**
 * Created by 1 on 18.04.2017.
 */
public class ValidatorRoomType extends AbstractValidator{
    public boolean validate(Map<String, String[]> data) throws IncorrectRoomBathroomsException, IncorrectRoomsCountException, IncorrectRoomBedsException, IncorrectRoomSizeException, IncorrectCostException, IncorrectRoomAdditionalInfoException {
        if (validateRoomsCountDigit(data.get("rooms_count")[0])
                & validateBedsCountDigit(data.get("beds_count")[0])
                & validateBathroomsCountDigit(data.get("bathrooms_count")[0])
                & validateSizeDigit(data.get("size")[0])
                & validateAdditionalInfo(data.get("additional_info")[0])
                & validateCostPerDayDigit(data.get("cost_per_day")[0])){
            return true;
        }
        return false;
    }

    private boolean validateRoomsCountDigit(String digit) throws IncorrectRoomsCountException {
        if(Integer.parseInt(digit) >= 0 & Integer.parseInt(digit) <= 5){
            return true;
        }
        throw new IncorrectRoomsCountException("Incorrect rooms count!");
    }

    private boolean validateBedsCountDigit(String digit) throws IncorrectRoomBedsException {
        if(Integer.parseInt(digit) >= 0 & Integer.parseInt(digit) <= 7){
            return true;
        }
        throw new IncorrectRoomBedsException("Incorrect beds count!");
    }

    private boolean validateBathroomsCountDigit(String digit) throws IncorrectRoomBathroomsException {
        if(Integer.parseInt(digit) >= 0 & Integer.parseInt(digit) <= 3){
            return true;
        }
        throw new IncorrectRoomBathroomsException("Incorrect bathrooms count!");
    }

    private boolean validateSizeDigit(String digit) throws IncorrectRoomSizeException {
        if(Integer.parseInt(digit) >= 0 & Integer.parseInt(digit) <= 200){
            return true;
        }
        throw new IncorrectRoomSizeException("Incorrect room size!");
    }

    private boolean validateCostPerDayDigit(String digit) throws IncorrectCostException {
        if(Float.parseFloat(digit) >= 0 & Float.parseFloat(digit) <= 100000){
            return true;
        }
        throw new IncorrectCostException("Incorrect room cost!");
    }

    private boolean validateAdditionalInfo(String info) throws IncorrectRoomAdditionalInfoException {
        if (info.length() > 15 & info.length() < 85) {
            return true;
        }
        throw new IncorrectRoomAdditionalInfoException("Incorrect additional room info!");
    }
}
