package by.hotel.factories.commandfactory.commandfactoriesimplementation;

import by.hotel.command.Command;
import by.hotel.command.impl.GetTableNames;
import by.hotel.factories.commandfactory.CommandFactory;

public class GetTablesNamesCommandFactory implements CommandFactory {
    public Command createCommand() {
        return new GetTableNames();
    }
}
