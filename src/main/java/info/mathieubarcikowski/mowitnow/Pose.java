package info.mathieubarcikowski.mowitnow;

import java.util.Objects;
import java.util.Scanner;

public class Pose
{
    private final Location location;
    private final Orientation orientation;

    public Pose(Location aLocation, Orientation anOrientation)
    {
        location = aLocation;
        orientation = anOrientation;
    }

    public static Pose parsePose(String input)
    {
        Scanner s = new Scanner(input).useDelimiter(" ");
        final int x = s.nextInt();
        final int y = s.nextInt();
        final String orientation = s.next();
        s.close();
        return new Pose(new Location(x, y), Orientation.parseOrientation(orientation));
    }

    public Location getLocation()
    {
        return location;
    }

    public Orientation getOrientation()
    {
        return orientation;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        Pose pose = (Pose) o;
        return Objects.equals(location, pose.location) &&
                Objects.equals(orientation, pose.orientation);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(location, orientation);
    }

    @Override
    public String toString()
    {
        return new StringBuilder()
                .append(location.getX())
                .append(' ')
                .append(location.getY())
                .append(' ')
                .append(orientation.getSymbol())
                .toString();
    }

}
