package by.hotel.command;

import by.hotel.command.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface Command {
    Object execute(Map<String, String[]> requestParameters, HttpServletRequest req) throws CommandException;
}