package by.hotel.command;

import by.hotel.command.exception.CommandException;

/**
 * Created by 1 on 28.02.2017.
 */
public interface Command {
<<<<<<< HEAD
    boolean execute(String request) throws CommandException;
=======
    Object execute(String request) throws CommandException;
>>>>>>> 7a10bbf86e232785ae7012f86561075f62debe5d
}
