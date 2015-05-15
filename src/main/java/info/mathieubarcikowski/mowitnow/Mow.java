package info.mathieubarcikowski.mowitnow;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

public class Mow
{
    private final Queue<Command> program;
    private Location location;
    private Orientation orientation;

    public Mow(Pose initialPose, Collection<Command> commands)
    {
        location = initialPose.getLocation();
        orientation = initialPose.getOrientation();
        program = new ArrayDeque<>(commands);
    }

    public void setLocation(Location aLocation)
    {
        location = aLocation;
    }

    public Orientation getOrientation()
    {
        return orientation;
    }

    public void setOrientation(Orientation anOrientation)
    {
        orientation = anOrientation;
    }

    public Location getFutureLocation()
    {
        return orientation.moveForward(location);
    }

    public boolean overlaps(Location aLocation)
    {
        return location.equals(aLocation);
    }

    public Mow executeProgram(final Environment anEnvironment)
    {
        program.stream()
               .forEach(command -> command.executeOn(this, anEnvironment));
        return this;
    }


    public Pose getPose()
    {
        return new Pose(location, orientation);
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder()
          .append(location)
          .append(' ')
          .append(orientation).append(", ")
          .append(program);
        return sb.toString();
    }
}
