package info.mathieubarcikowski.mowitnow;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

public class Environment {
  private final Lawn lawn;
  private final List<Mow> mows;

  public Environment(Lawn environmentLawn, Mow... environmentMows) {
    lawn = environmentLawn;
    mows = Lists.newArrayList(environmentMows);
  }

  /**
   * Verifies a location of a mow is in the Lawn and don't collide with others
   * mows.
   *
   * @param location location to verify.
   * @return true if the mow can move to the location.
   */
  public boolean isValidLocation(final Location location) {
    return lawn.includes(location)
      && mows.stream()
             .collect(Collectors.reducing(
               true,
               mow ->
                 !mow.overlaps(location),
               (accumulator, notOverlaps) ->
                 accumulator && notOverlaps));
  }

  public List<Mow> getMows() {
    return mows;
  }
}
