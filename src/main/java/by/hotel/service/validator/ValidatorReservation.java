package by.hotel.service.validator;

import by.hotel.bean.Reservation;
import by.hotel.bean.Role;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by 1 on 18.04.2017.
 */
public class ValidatorReservation extends AbstractValidator{
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
    public boolean validate(Map<String, String[]> data) {
        if (validateDate(data.get("dateIn")[0]) & validateDate(data.get("dateOut")[0])
                & validateUnsignedIntDigit(data.get("costAdditionalServices")[0])) {
            return true;
        }

        return false;
    }

    private boolean validateDate(String date) {
        try {
            return DATE_FORMAT.format(DATE_FORMAT.parse(date)).equals(date);
        }catch (ParseException ex){
            return false;
        }
    }

    private boolean validateUnsignedIntDigit(String digit) {
        if(Integer.parseInt(digit) >= 0){
            return true;
        }
        return false;
    }
}