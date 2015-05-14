package info.mathieubarcikowski.mowitnow;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

public class Mow
{
    private final Orientation orientation;

    private final Position position;

    private final Queue<Command> program;

    public Mow(Orientation initialOrientation, Position initialPosition, Collection<Command> aCommands)
    {
        orientation = initialOrientation;
        position = initialPosition;
        program =  new ArrayDeque(aCommands);
    }
}
