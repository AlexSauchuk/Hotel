package by.hotel.command.impl;

import by.hotel.command.Command;
import by.hotel.command.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by 1 on 02.05.2017.
 */
public class Logout implements Command {

    @Override
    public Object execute(Map<String, String[]> requestParameters, HttpServletRequest req) throws CommandException {
        HttpSession session = req.getSession();
        session.invalidate();
        return true;
    }
}
