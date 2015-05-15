package info.mathieubarcikowski.mowitnow;

import static info.mathieubarcikowski.mowitnow.Locations.ORIGIN;

import java.util.Scanner;

public class Lawn {
  private final Location southWestLocation;
  private final Location northEastLocation;

  public Lawn(Location lawnNorthEastLocation) {
    southWestLocation = ORIGIN;
    northEastLocation = lawnNorthEastLocation;
  }

  /**
   * Parse an input string in order to retrieve a lawn.
   * Input string is composed by "X Y", X representing x coordinate,
   * Y representing y coordinate.
   *
   * @param input string to be parsed.
   * @return a lawn.
   */
  public static Lawn parseLawn(String input) {
    Scanner scanner = new Scanner(input).useDelimiter(" ");
    final int x = scanner.nextInt();
    final int y = scanner.nextInt();
    scanner.close();
    return new Lawn(new Location(x, y));
  }

  /**
   * Verify if a location is included in lawn.
   *
   * @param location location to verify.
   * @return true if location is included in lawn.
   */
  public boolean includes(Location location) {
    final int x = location.getCoordinateX();
    final int y = location.getCoordinateY();
    return southWestLocation.getCoordinateX() <= x
      && x <= northEastLocation.getCoordinateX()
      && southWestLocation.getCoordinateY() <= y
      && y <= northEastLocation.getCoordinateY();
  }
}
