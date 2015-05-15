package info.mathieubarcikowski.mowitnow;

import static info.mathieubarcikowski.mowitnow.Orientation.EAST;
import static info.mathieubarcikowski.mowitnow.Orientation.NORTH;
import static info.mathieubarcikowski.mowitnow.Orientation.SOUTH;
import static info.mathieubarcikowski.mowitnow.Orientation.WEST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown;

import org.junit.Test;

public class OrientationTest {

  @Test
  public void testParseOrientation() throws Exception {
    //then
    assertThat(Orientation.parseOrientation("N")).isEqualTo(NORTH);
    assertThat(Orientation.parseOrientation("S")).isEqualTo(SOUTH);
    assertThat(Orientation.parseOrientation("E")).isEqualTo(EAST);
    assertThat(Orientation.parseOrientation("W")).isEqualTo(WEST);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testParseOrientation_with_unknown_orientation_should_throws_illegalArgumentException() throws Exception {
    //when
    Orientation.parseOrientation("U");

    failBecauseExceptionWasNotThrown(IllegalArgumentException.class);
  }

  @Test
  public void testGetSymbol() throws Exception {
    //then
    assertThat(NORTH.getSymbol()).isEqualTo("N");
    assertThat(SOUTH.getSymbol()).isEqualTo("S");
    assertThat(EAST.getSymbol()).isEqualTo("E");
    assertThat(WEST.getSymbol()).isEqualTo("W");
  }

  @Test
  public void testTurnLeft() throws Exception {
    //then
    assertThat(NORTH.turnLeft()).isEqualTo(WEST);
    assertThat(SOUTH.turnLeft()).isEqualTo(EAST);
    assertThat(EAST.turnLeft()).isEqualTo(NORTH);
    assertThat(WEST.turnLeft()).isEqualTo(SOUTH);
  }

  @Test
  public void testTurnRight() throws Exception {
    //then
    assertThat(NORTH.turnRight()).isEqualTo(EAST);
    assertThat(SOUTH.turnRight()).isEqualTo(WEST);
    assertThat(EAST.turnRight()).isEqualTo(SOUTH);
    assertThat(WEST.turnRight()).isEqualTo(NORTH);
  }

  @Test
  public void testMoveForward() throws Exception {
    //then
    assertThat(NORTH.moveForward(new Location(0, 0))).isEqualTo(new Location(0, 1));
    assertThat(SOUTH.moveForward(new Location(0, 0))).isEqualTo(new Location(0, -1));
    assertThat(EAST.moveForward(new Location(0, 0))).isEqualTo(new Location(1, 0));
    assertThat(WEST.moveForward(new Location(0, 0))).isEqualTo(new Location(-1, 0));
  }

  @Test
  public void testToString() throws Exception {
    //then
    assertThat(NORTH.toString()).isEqualTo("N");
    assertThat(SOUTH.toString()).isEqualTo("S");
    assertThat(EAST.toString()).isEqualTo("E");
    assertThat(WEST.toString()).isEqualTo("W");
  }

  @Test
  public void testValueOf() throws Exception {
    //then
    assertThat(Orientation.valueOf("NORTH")).isEqualTo(NORTH);
    assertThat(Orientation.valueOf("SOUTH")).isEqualTo(SOUTH);
    assertThat(Orientation.valueOf("EAST")).isEqualTo(EAST);
    assertThat(Orientation.valueOf("WEST")).isEqualTo(WEST);

  }
}