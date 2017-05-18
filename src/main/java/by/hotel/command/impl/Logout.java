package by.hotel.command.impl;

import by.hotel.command.Command;
import by.hotel.command.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout implements Command {

    @Override
    public Object execute(HttpServletRequest req, HttpServletResponse response) throws CommandException {
        return true;
    }
}
