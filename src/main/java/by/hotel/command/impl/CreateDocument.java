package by.hotel.command.impl;

import by.hotel.command.Command;
import by.hotel.command.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class CreateDocument implements Command {
    public Object execute(HttpServletRequest req) throws CommandException {
        return null;
    }
}
