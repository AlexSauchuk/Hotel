package by.hotel.factories.commandfactory.commandfactoriesimplementation;

import by.hotel.factories.commandfactory.CommandFactory;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user1 on 16.03.2017.
 */
public final class CommandFactoryMapper {
    final private static Map<String, CommandFactory> commands = new HashMap();

    static {
        commands.put("GET_ALL", new GetAllEntitiesCommandFactory());
        commands.put("ADD", new AddEntityCommandFactory());
        commands.put("REMOVE", new RemoveEntityCommandFactory());
        commands.put("UPDATE", new UpdateEntityCommandFactory());
        commands.put("ADMIN_START",new GetTablesNamesCommandFactory());
    }

    public static CommandFactory getCommandFactory(String commandName) {
        return commands.get(commandName);
    }
}