package by.hotel.service.validator;

import by.hotel.bean.Discount;
import by.hotel.bean.Role;

import java.util.Map;

/**
 * Created by 1 on 18.04.2017.
 */
public class ValidatorDiscount extends AbstractValidator {
    public boolean validate(Map<String, String[]> data) {
        if (validateNameDiscount(data.get("name")[0])) {
            return true;
        }
        return false;
    }

    private boolean validateNameDiscount(String nameDiscount) {
        if (nameDiscount.length() > 45) {
            return false;
        }
        return true;
    }
}
