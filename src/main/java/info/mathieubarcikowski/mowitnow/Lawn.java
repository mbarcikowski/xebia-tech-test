package info.mathieubarcikowski.mowitnow;

import java.util.Scanner;

import static info.mathieubarcikowski.mowitnow.Locations.ORIGIN;

public class Lawn
{
    private final Location southWestLocation;
    private final Location northEastLocation;

    public Lawn(Location aNorthEastLocation)
    {
        southWestLocation = ORIGIN;
        northEastLocation = aNorthEastLocation;
    }

    public boolean includes(Location aLocation)
    {
        final int x = aLocation.getX();
        final int y = aLocation.getY();
        return southWestLocation.getX() <= x
                && x <= northEastLocation.getX()
                && southWestLocation.getY() <= y
                && y <= northEastLocation.getY();
    }

    public static Lawn parseLawn(String input)
    {
        Scanner s = new Scanner(input).useDelimiter(" ");
        final int x = s.nextInt();
        final int y = s.nextInt();
        s.close();
        return new Lawn(new Location(x, y));
    }
}
