package by.hotel.service.validator;

import by.hotel.bean.Role;

import java.util.Map;

/**
 * Created by 1 on 18.04.2017.
 */
public class ValidatorRole extends AbstractValidator{
    public boolean validate(Map<String, String[]> data) {
        if (validateNameRole(data.get("name_role")[0]) & validateRight(data.get("update")[0]) & validateRight(data.get("delete")[0])
                &validateRight(data.get("insert")[0]) & validateRight(data.get("create")[0]) & validateRight(data.get("select")[0])
                &validateRight(data.get("drop")[0]) & validateRight(data.get("grant")[0])){
            return true;
        }

        return false;
    }

    private boolean validateNameRole(String nameRole) {
        if (nameRole.length() > 50) {
            return false;
        }
        return true;
    }

    private boolean validateRight(String right) {
        if(Integer.parseInt(right) == 0 | Integer.parseInt(right) == 1){
            return true;
        }
        return false;
    }


}
