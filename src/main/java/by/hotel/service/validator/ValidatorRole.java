package by.hotel.service.validator;

import by.hotel.service.exception.IncorrectNameRoleException;
import by.hotel.service.exception.IncorrectRightRoleException;

import java.util.Map;

/**
 * Created by 1 on 18.04.2017.
 */
public class ValidatorRole extends AbstractValidator{
    public boolean validate(Map<String, String[]> data) throws IncorrectRightRoleException, IncorrectNameRoleException {
        if (validateNameRole(data.get("nameRole")[0]) & validateRight(data.get("update")[0]) & validateRight(data.get("delete")[0])
                &validateRight(data.get("insert")[0]) & validateRight(data.get("create")[0]) & validateRight(data.get("select")[0])
                &validateRight(data.get("drop")[0]) & validateRight(data.get("grant")[0])){
            return true;
        }
        return false;
    }

    private boolean validateNameRole(String nameRole) throws IncorrectNameRoleException {
        if (nameRole.length() > 3 & nameRole.length() < 50) {
            return true;
        }
        throw new IncorrectNameRoleException("Incorrect name role!");
    }

    private boolean validateRight(String right)throws IncorrectRightRoleException {
        if(Integer.parseInt(right) == 0 | Integer.parseInt(right) == 1){
            return true;
        }
        throw new IncorrectRightRoleException("Incorrect right role!");
    }
}
