package by.hotel.factories.commandfactory.commandfactoriesimpl;

import by.hotel.command.Command;
import by.hotel.command.impl.UpdateEntity;
import by.hotel.factories.commandfactory.CommandFactory;

public class UpdateEntityCommandFactory implements CommandFactory {
    public Command createCommand() {
        return new UpdateEntity();
    }
}
