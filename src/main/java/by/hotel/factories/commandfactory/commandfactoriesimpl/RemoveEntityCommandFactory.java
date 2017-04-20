package by.hotel.factories.commandfactory.commandfactoriesimpl;

import by.hotel.command.Command;
import by.hotel.command.impl.RemoveEntity;
import by.hotel.factories.commandfactory.CommandFactory;

public class RemoveEntityCommandFactory implements CommandFactory {
    public Command createCommand() {
        return new RemoveEntity();
    }
}
