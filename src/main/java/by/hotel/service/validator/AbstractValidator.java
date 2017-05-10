package by.hotel.service.validator;

import java.util.Map;

public abstract class AbstractValidator {
    public abstract boolean validate(Map<String, String[]> data) throws Exception;
}
