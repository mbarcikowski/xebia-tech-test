package info.mathieubarcikowski.mowitnow;

public class Lawn
{
    private final int xCoordinate;
    private final int yCoordinate;

    public Lawn(int aXCoordinate, int aYCoordinate)
    {
        xCoordinate = aXCoordinate;
        yCoordinate = aYCoordinate;
    }

    public boolean includes(int aXCoordinate, int aYCoordinate)
    {
        return 0 <= aXCoordinate
                   && aXCoordinate <= xCoordinate
                   && 0 <= aYCoordinate
                   && aYCoordinate <= yCoordinate;
    }
}
