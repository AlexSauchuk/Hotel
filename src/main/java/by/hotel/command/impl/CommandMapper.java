package by.hotel.command.impl;

import by.hotel.command.Command;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user1 on 16.03.2017.
 */
final class CommandMapper {
    final private static Map<String, Command> commands = new HashMap();

    static {
        commands.put("LOGINATION_USER", new Logination());
        commands.put("LOGINATION_ADMIN", new Logination());
        commands.put("REGISTRATION", new Registration());
    }

    public static Command getCommand(String commandName) {
        return commands.get(commandName);
    }
}