package by.hotel.factory.impl;

import by.hotel.command.Command;
import by.hotel.command.impl.*;
import by.hotel.factory.CommandFactory;

import java.util.HashMap;
import java.util.Map;

public final class CommandFactoryMapper implements CommandFactory {
    final private static Map<String, Command> commands = new HashMap();

    static {
        commands.put("GET_ALL", new GetAllEntities());
        commands.put("ADD", new AddEntity());
        commands.put("REMOVE", new RemoveEntity());
        commands.put("UPDATE", new UpdateEntity());
        commands.put("ADMIN_START",new GetTableNames());
        commands.put("GET_ALL_HEADERS",new GetEntityHeaders());
        commands.put("CREATE_DOCUMENT", new CreateDocument());
        commands.put("AUTHORIZATION", new Authorization());
        commands.put("REGISTRATION", new Registration());
    }

    private static class Holder{
        private final static CommandFactoryMapper INSTANCE = new CommandFactoryMapper();
    }

    public static CommandFactoryMapper getInstance(){
        return Holder.INSTANCE;
    }

    public Command getCommand(String commandName) {
        return commands.get(commandName.toUpperCase());
    }
}