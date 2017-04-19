package by.hotel.service.validator;

import by.hotel.service.exception.*;

import java.text.ParseException;
import java.util.Map;

/**
 * Created by 1 on 18.04.2017.
 */
public abstract class AbstractValidator {
    public abstract boolean validate(Map<String, String[]> data) throws Exception;
}
