package info.mathieubarcikowski.mowitnow;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

public class Mow {
  private final Queue<Command> program;
  private Location location;
  private Orientation orientation;

  /**
   * Construct a new mow.
   *
   * @param initialPose initial pose of the mow.
   * @param commands    list of commands to be executed by the mow.
   */
  public Mow(Pose initialPose, Collection<Command> commands) {
    location = initialPose.getLocation();
    orientation = initialPose.getOrientation();
    program = new ArrayDeque<>(commands);
  }

  public void setLocation(Location newLocation) {
    location = newLocation;
  }

  public Orientation getOrientation() {
    return orientation;
  }

  public void setOrientation(Orientation newOrientation) {
    orientation = newOrientation;
  }

  public Location getFutureLocation() {
    return orientation.moveForward(location);
  }

  public boolean overlaps(Location otherLocation) {
    return location.equals(otherLocation);
  }

  /**
   * Executes the program of the mows.
   *
   * @param environment environment in which the mow evolves.
   * @return the final state of the mow.
   */
  public Mow executeProgram(final Environment environment) {
    program.stream()
           .forEach(command -> command.executeOn(this, environment));
    return this;
  }


  public Pose getPose() {
    return new Pose(location, orientation);
  }

  @Override
  public String toString() {
    return new StringBuilder()
      .append(location)
      .append(' ')
      .append(orientation)
      .append(", ")
      .append(program)
      .toString();
  }
}
