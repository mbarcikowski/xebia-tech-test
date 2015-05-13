package info.mathieubarcikowski.mowitnow;

public class Mow
{
    private final Orientation orientation;

    private final int xCoordinate;
    private final int yCoordinate;

    public Mow(Orientation anOrientation, int aXCoordinate, int aYCoordinate)
    {
        orientation = anOrientation;
        xCoordinate = aXCoordinate;
        yCoordinate = aYCoordinate;
    }
}
