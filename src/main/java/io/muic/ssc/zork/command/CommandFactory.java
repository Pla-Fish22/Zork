package io.muic.ssc.zork.command;

import io.muic.ssc.zork.command.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class CommandFactory {

    private static final List<Class<?>> REGISTERED_COMMANDS = Arrays.asList(ExitCommand.class,
            HelpCommand.class, InfoCommand.class, PlayCommand.class, AttackCommand.class, TakeCommand.class);

    private static final Map<String, Command> COMMAND_MAP = new HashMap<>();

    static {
        {
            for (Class<?> commandClass : REGISTERED_COMMANDS) {
                try {
                    Command command = (Command) commandClass.getDeclaredConstructor().newInstance();
                    COMMAND_MAP.put(command.getCommand(), command);
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Command get(List<String> command) {
        if(COMMAND_MAP.containsKey(command.get(0).toLowerCase(Locale.ROOT))){
            return COMMAND_MAP.get(command.get(0).toLowerCase(Locale.ROOT));
        }
        return null;
    }

    public static List<String> getAllCommand() {
        return new ArrayList<>(COMMAND_MAP.keySet());
    }
}
