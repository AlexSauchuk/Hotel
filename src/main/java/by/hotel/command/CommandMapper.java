package by.hotel.command;

import by.hotel.command.impl.AddEntity;
import by.hotel.command.impl.GetAllEntities;
import by.hotel.command.impl.RemoveEntity;
import by.hotel.command.impl.UpdateEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user1 on 16.03.2017.
 */
final class CommandMapper {
    final private static Map<String, Command> commands = new HashMap();

    static {
        commands.put("GET_ALL", new GetAllEntities());
        commands.put("ADD", new AddEntity());
        commands.put("REMOVE", new RemoveEntity());
        commands.put("UPDATE", new UpdateEntity());
    }

    public static Command getCommand(String commandName) {
        return commands.get(commandName);
    }
}