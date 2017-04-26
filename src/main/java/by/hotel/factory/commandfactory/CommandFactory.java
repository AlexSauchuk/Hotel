package by.hotel.factory.commandfactory;

import by.hotel.command.Command;

public interface CommandFactory {
    Command createCommand(String commandName);
}
