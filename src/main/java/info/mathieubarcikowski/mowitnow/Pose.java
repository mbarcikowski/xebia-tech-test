package info.mathieubarcikowski.mowitnow;

import java.util.Objects;
import java.util.Scanner;

public class Pose {
  private final Location location;
  private final Orientation orientation;

  public Pose(Location poseLocation, Orientation poseOrientation) {
    location = poseLocation;
    orientation = poseOrientation;
  }

  /**
   * Parse an input string in order to retrieve a pose.
   * Input string is composed by "X Y O", X representing x coordinate,
   * Y representing y coordinate, O representing an orientation.
   *
   * @param input string to be parsed.
   * @return a pose.
   */
  public static Pose parsePose(String input) {
    Scanner scanner = new Scanner(input).useDelimiter(" ");
    final int x = scanner.nextInt();
    final int y = scanner.nextInt();
    final String orientation = scanner.next();
    scanner.close();
    return new Pose(new Location(x, y), Orientation.parseOrientation(orientation));
  }

  public Location getLocation() {
    return location;
  }

  public Orientation getOrientation() {
    return orientation;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Pose pose = (Pose) object;
    return Objects.equals(location, pose.location)
      && Objects.equals(orientation, pose.orientation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(location, orientation);
  }

  @Override
  public String toString() {
    return new StringBuilder()
      .append(location.getCoordinateX())
      .append(' ')
      .append(location.getCoordinateY())
      .append(' ')
      .append(orientation.getSymbol())
      .toString();
  }

}
