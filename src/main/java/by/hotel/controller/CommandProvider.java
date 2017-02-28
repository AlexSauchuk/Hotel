package by.hotel.controller;

import by.hotel.command.Command;
import by.hotel.command.impl.Logination;
import by.hotel.command.impl.Registration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1 on 28.02.2017.
 */
final class CommandProvider {
    final private Map<String, Command> commands = new HashMap();

    CommandProvider() {
        commands.put("LOGINATION_USER", new Logination());
        commands.put("LOGINATION_ADMIN", new Logination());
        commands.put("REGISTRATION", new Registration());
    }

    Command getCommand(String commandName) {
        Command command = commands.get(commandName);
        return command;
    }
}