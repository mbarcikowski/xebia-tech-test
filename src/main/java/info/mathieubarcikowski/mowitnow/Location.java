package info.mathieubarcikowski.mowitnow;

import java.util.Objects;

public class Location {
  private final int coordinateX;
  private final int coordinateY;

  public Location(int locationCoordinateX, int locationCoordinateY) {
    coordinateX = locationCoordinateX;
    coordinateY = locationCoordinateY;
  }

  public int getCoordinateX() {
    return coordinateX;
  }

  public int getCoordinateY() {
    return coordinateY;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Location location = (Location) object;
    return Objects.equals(coordinateX, location.coordinateX)
      && Objects.equals(coordinateY, location.coordinateY);
  }

  @Override
  public int hashCode() {
    return Objects.hash(coordinateX, coordinateY);
  }

  @Override
  public String toString() {
    return new StringBuilder(3)
      .append(coordinateX)
      .append(' ')
      .append(coordinateY)
      .toString();
  }
}
