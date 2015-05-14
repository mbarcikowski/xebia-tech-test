package info.mathieubarcikowski.mowitnow;

public enum Orientation
{
    NORTH
            {
                @Override
                public Orientation turnLeft()
                {
                    return WEST;
                }

                @Override
                public Orientation turnRight()
                {
                    return EASTH;
                }
            },
    WEST
            {
                @Override
                public Orientation turnLeft()
                {
                    return SOUTH;
                }

                @Override
                public Orientation turnRight()
                {
                    return NORTH;
                }
            },
    EASTH
            {
                @Override
                public Orientation turnLeft()
                {
                    return NORTH;
                }

                @Override
                public Orientation turnRight()
                {
                    return SOUTH;
                }
            },
    SOUTH
            {
                @Override
                public Orientation turnLeft()
                {
                    return EASTH;
                }

                @Override
                public Orientation turnRight()
                {
                    return WEST;
                }
            };

    public abstract Orientation turnLeft();

    public abstract Orientation turnRight();
}
