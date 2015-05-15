package info.mathieubarcikowski.mowitnow;

import java.util.Objects;

public class Location
{
    private final int x;
    private final int y;

    public Location(int aX, int aY)
    {
        x = aX;
        y = aY;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
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
        Location location = (Location) o;
        return Objects.equals(x, location.x) &&
                Objects.equals(y, location.y);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(x, y);
    }

    @Override
    public String toString()
    {
        return new StringBuilder(3)
                .append(x)
                .append(' ')
                .append(y)
                .toString();
    }
}
