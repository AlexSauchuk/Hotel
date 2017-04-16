package by.hotel.command;

import by.hotel.command.exception.CommandException;

import java.util.Map;

public interface Command {
    Object execute(Map<String, String[]> requestParameters) throws CommandException;
}
