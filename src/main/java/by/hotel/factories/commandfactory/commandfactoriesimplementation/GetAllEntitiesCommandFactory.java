package by.hotel.factories.commandfactory.commandfactoriesimplementation;

import by.hotel.command.Command;
import by.hotel.command.impl.GetAllEntities;
import by.hotel.factories.commandfactory.CommandFactory;

public class GetAllEntitiesCommandFactory implements CommandFactory {
    public Command createCommand() {
        return new GetAllEntities();
    }
}
