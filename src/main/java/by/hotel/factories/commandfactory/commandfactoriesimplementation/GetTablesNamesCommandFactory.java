package by.hotel.factories.commandfactory.commandfactoriesimplementation;

import by.hotel.command.Command;
import by.hotel.command.impl.GetTableNames;
import by.hotel.factories.commandfactory.CommandFactory;

/**
 * Created by user1 on 29.03.2017.
 */
public class GetTablesNamesCommandFactory implements CommandFactory {
    public Command createCommand() {
        return new GetTableNames();
    }
}
