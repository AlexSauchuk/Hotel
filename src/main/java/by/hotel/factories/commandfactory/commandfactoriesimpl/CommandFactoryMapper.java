package by.hotel.factories.commandfactory.commandfactoriesimpl;

import by.hotel.factories.commandfactory.CommandFactory;
import java.util.HashMap;
import java.util.Map;

public final class CommandFactoryMapper {
    final private static Map<String, CommandFactory> commands = new HashMap();

    static {
        commands.put("GET_ALL", new GetAllEntitiesCommandFactory());
        commands.put("ADD", new AddEntityCommandFactory());
        commands.put("REMOVE", new RemoveEntityCommandFactory());
        commands.put("UPDATE", new UpdateEntityCommandFactory());
        commands.put("ADMIN_START",new GetTablesNamesCommandFactory());
        commands.put("GET_ALL_HEADERS",new GetAllHeadersCommandFactory());
    }

    public static CommandFactory getCommandFactory(String commandName) {
        return commands.get(commandName);
    }
}