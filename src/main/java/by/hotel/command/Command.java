package by.hotel.command;

import by.hotel.command.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface Command {
    Object execute(HttpServletRequest req) throws CommandException;
}