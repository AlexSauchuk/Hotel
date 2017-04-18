package by.hotel.factories.commandfactory.commandfactoriesimpl;

import by.hotel.command.Command;
import by.hotel.command.impl.AddEntity;
import by.hotel.factories.commandfactory.CommandFactory;

public class AddEntityCommandFactory implements CommandFactory {
    public Command createCommand() {
        return new AddEntity();
    }
}
