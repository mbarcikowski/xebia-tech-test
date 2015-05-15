package info.mathieubarcikowski.mowitnow;

import java.util.*;

public enum Commands implements Command
{

    TURN_RIGHT('D')
            {
                @Override
                public void executeOn(Mow aMow, Environment aEnvironment)
                {
                    final Orientation currentOrientation = aMow.getOrientation();
                    aMow.setOrientation(currentOrientation.turnRight());
                }
            },
    TURN_LEFT('G')
            {
                @Override
                public void executeOn(Mow aMow, Environment aEnvironment)
                {
                    final Orientation currentOrientation = aMow.getOrientation();
                    aMow.setOrientation(currentOrientation.turnLeft());
                }
            },
    MOVE_FORWARD('A')
            {
                @Override
                public void executeOn(Mow aMow, Environment aEnvironment)
                {
                    final Location nextLocation = aMow.getFutureLocation();
                    if (aEnvironment.isValidLocation(nextLocation))
                    {
                        aMow.setLocation(nextLocation);
                    }
                }
            };

    private static Map<Character, Command> commandBySymbol = new HashMap<>(Commands.values().length);

    static
    {
        for (Commands command : Commands.values())
        {
            commandBySymbol.put(command.getSymbol(), command);
        }
    }

    private char symbol;

    Commands(char aSymbol)
    {

        symbol = aSymbol;
    }

    public static Collection<Command> parseCommands(String input)
    {
        List<Command> commands = new ArrayList<>(input.length());
        for (char c : input.toCharArray())
        {
            final Command command = commandBySymbol.get(c);
            if (command == null)
            {
                throw new IllegalArgumentException(String.format("unknown command '%s'", c));
            } else
            {
                commands.add(command);
            }
        }
        return commands;
    }

    public char getSymbol()
    {
        return symbol;
    }

    @Override
    public String toString()
    {
        return String.valueOf(symbol);
    }
}
