package info.mathieubarcikowski.mowitnow;

public enum Orientation {
  NORTH("N") {
    @Override
    public Orientation turnLeft() {
      return WEST;
    }

    @Override
    public Orientation turnRight() {
      return EAST;
    }

    @Override
    public Location moveForward(Location location) {
      return new Location(location.getCoordinateX(), location.getCoordinateY() + 1);
    }
  },
  WEST("W") {
    @Override
    public Orientation turnLeft() {
      return SOUTH;
    }

    @Override
    public Orientation turnRight() {
      return NORTH;
    }

    @Override
    public Location moveForward(Location location) {
      return new Location(location.getCoordinateX() - 1, location.getCoordinateY());
    }
  },
  EAST("E") {
    @Override
    public Orientation turnLeft() {
      return NORTH;
    }

    @Override
    public Orientation turnRight() {
      return SOUTH;
    }

    @Override
    public Location moveForward(Location location) {
      return new Location(location.getCoordinateX() + 1, location.getCoordinateY());
    }
  },
  SOUTH("S") {
    @Override
    public Orientation turnLeft() {
      return EAST;
    }

    @Override
    public Orientation turnRight() {
      return WEST;
    }

    @Override
    public Location moveForward(Location location) {
      return new Location(location.getCoordinateX(), location.getCoordinateY() - 1);
    }
  };

  private final String symbol;

  Orientation(String orientationSymbol) {
    symbol = orientationSymbol;
  }

  /**
   * Parse an input string in order to retrieve an orientation.
   * Input string is either 'N','E','W' or 'S'.
   *
   * @param input string to be parsed.
   * @return a orientation.
   */
  public static Orientation parseOrientation(String input) {
    for (Orientation orientation : Orientation.values()) {
      if (orientation.getSymbol()
                     .equals(input)) {
        return orientation;
      }
    }
    throw new IllegalArgumentException(String.format("unknown orientation '%s'", input));

  }

  public String getSymbol() {
    return symbol;
  }

  public abstract Orientation turnLeft();

  public abstract Orientation turnRight();

  public abstract Location moveForward(Location location);

  @Override
  public String toString() {
    return symbol;
  }
}
