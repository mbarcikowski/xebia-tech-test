package info.mathieubarcikowski.mowitnow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Commands implements Command {

  TURN_RIGHT('D') {
    @Override
    public void executeOn(Mow mow, Environment environment) {
      final Orientation currentOrientation = mow.getOrientation();
      mow.setOrientation(currentOrientation.turnRight());
    }
  },
  TURN_LEFT('G') {
    @Override
    public void executeOn(Mow mow, Environment environment) {
      final Orientation currentOrientation = mow.getOrientation();
      mow.setOrientation(currentOrientation.turnLeft());
    }
  },
  MOVE_FORWARD('A') {
    @Override
    public void executeOn(Mow mow, Environment environment) {
      final Location nextLocation = mow.getFutureLocation();
      if (environment.isValidLocation(nextLocation)) {
        mow.setLocation(nextLocation);
      }
    }
  };

  private static Map<Character, Command> commandBySymbol = new HashMap<>(Commands.values().length);

  static {
    for (Commands command : Commands.values()) {
      commandBySymbol.put(command.getSymbol(), command);
    }
  }

  private char symbol;

  Commands(char commandSymbol) {
    symbol = commandSymbol;
  }

  /**
   * Parse an input string in order to retrieve a collection of command.
   * Input string is composed by a sequence of characters 'A','D' or 'G'.
   *
   * @param input string to be parsed.
   * @return a collection of command.
   */
  public static Collection<Command> parseCommands(String input) {
    List<Command> commands = new ArrayList<>(input.length());
    for (char c : input.toCharArray()) {
      final Command command = commandBySymbol.get(c);
      if (command == null) {
        throw new IllegalArgumentException(String.format("unknown command '%s'", c));
      } else {
        commands.add(command);
      }
    }
    return commands;
  }

  public char getSymbol() {
    return symbol;
  }

  @Override
  public String toString() {
    return String.valueOf(symbol);
  }
}
