package info.mathieubarcikowski.mowitnow;

public class Lawn
{
    private final Position southWestPosition;
    private final Position northEastPosition;

    public Lawn(Position aSouthWestPosition, Position aNorthEastPosition)
    {
        this.southWestPosition = aSouthWestPosition;
        this.northEastPosition = aNorthEastPosition;
    }

    public boolean includes(Position aPosition)
    {
        final int x = aPosition.getX();
        final int y = aPosition.getY();
        return southWestPosition.getX() <= x
                && x <= northEastPosition.getX()
                && southWestPosition.getY() <= y
                && y <= northEastPosition.getY();
    }
}
