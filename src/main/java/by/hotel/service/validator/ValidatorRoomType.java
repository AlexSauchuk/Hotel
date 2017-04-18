package by.hotel.service.validator;

import java.util.Map;

/**
 * Created by 1 on 18.04.2017.
 */
public class ValidatorRoomType extends AbstractValidator{
    public boolean validate(Map<String, String[]> data) {
        if (validateUnsignedIntDigit(data.get("rooms_count")[0])
                & validateUnsignedIntDigit(data.get("beds_count")[0])
                & validateUnsignedIntDigit(data.get("bathrooms_count")[0])
                & validateUnsignedIntDigit(data.get("rooms_count")[0])
                & validateUnsignedIntDigit(data.get("size")[0])
                & validateAdditionalInfo(data.get("additional_info")[0])
                & validateUnsignedFloatDigit(data.get("cost_per_day")[0])){
            return true;
        }
        return false;
    }

    private boolean validateUnsignedIntDigit(String digit) {
        if(Integer.parseInt(digit) >= 0){
            return true;
        }
        return false;
    }

    private boolean validateUnsignedFloatDigit(String digit) {
        if(Float.parseFloat(digit) >= 0){
            return true;
        }
        return false;
    }

    private boolean validateAdditionalInfo(String info) {
        if (info.length() > 45) {
            return false;
        }
        return true;
    }
}
