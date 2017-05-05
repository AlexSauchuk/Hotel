package by.hotel.command.impl;

import by.hotel.command.Command;
import by.hotel.command.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class CreateDocument implements Command {
    public Object execute(Map<String, String[]> requestParameters, HttpServletRequest req) throws CommandException {
        return null;
    }
}
