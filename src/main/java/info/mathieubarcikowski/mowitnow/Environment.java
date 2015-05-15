package info.mathieubarcikowski.mowitnow;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

public class Environment
{
    private final Lawn lawn;
    private final List<Mow> mows;

    public Environment(Lawn aLawn, Mow... aMows)
    {
        lawn = aLawn;
        mows = Lists.newArrayList(aMows);
    }

    public boolean isValidLocation(final Location aNextLocation)
    {
        return lawn.includes(aNextLocation) &
                mows.stream()
                    .collect(Collectors.reducing(
                            true,
                            mow -> !mow.overlaps(aNextLocation),
                            (accumulator, notOverlaps) -> accumulator && notOverlaps));
    }

    public List<Mow> getMows()
    {
        return mows;
    }
}
