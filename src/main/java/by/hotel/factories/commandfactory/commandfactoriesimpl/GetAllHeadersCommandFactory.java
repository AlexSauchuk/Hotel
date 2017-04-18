package by.hotel.factories.commandfactory.commandfactoriesimpl;

import by.hotel.command.Command;
import by.hotel.command.impl.GetEntityHeaders;
import by.hotel.factories.commandfactory.CommandFactory;

public class GetAllHeadersCommandFactory implements CommandFactory{
    public Command createCommand() {
        return new GetEntityHeaders();
    }
}
