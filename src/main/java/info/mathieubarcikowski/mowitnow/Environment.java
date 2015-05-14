package info.mathieubarcikowski.mowitnow;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Environment
{
    private final Set<Mow> mows;
    private final Lawn lawn;

    public Environment(Set<Mow> aMows, Lawn aLawn)
    {
        mows = aMows;
        lawn = aLawn;
    }
}
