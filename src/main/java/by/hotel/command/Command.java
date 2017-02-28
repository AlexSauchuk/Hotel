package by.hotel.command;

import by.hotel.command.exception.CommandException;

/**
 * Created by 1 on 28.02.2017.
 */
public interface  Command {
    boolean execute(String request) throws CommandException;
}
