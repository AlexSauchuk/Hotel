package by.hotel.factory;

import by.hotel.command.Command;

public interface CommandFactory {
    Command getCommand(String commandName);
}
