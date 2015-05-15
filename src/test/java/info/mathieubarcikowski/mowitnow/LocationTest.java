package info.mathieubarcikowski.mowitnow;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class LocationTest {

  private Location location;

  @Before
  public void setUp() throws Exception {
    location = new Location(42, 13);
  }

  @Test
  public void testGetCoordinateX() throws Exception {
    //then
    assertThat(location.getCoordinateX()).isEqualTo(42);
  }

  @Test
  public void testGetCoordinateY() throws Exception {
    //then
    assertThat(location.getCoordinateY()).isEqualTo(13);
  }

  @Test
  public void testEquals() throws Exception {
    //then
    assertThat(location.equals(location)).isTrue();
    assertThat(location.equals(new Location(42, 13))).isTrue();
    assertThat(location.equals(new Location(0, 13))).isFalse();
    assertThat(location.equals(new Location(42, 0))).isFalse();
    assertThat(location.equals(new Object())).isFalse();
    assertThat(location.equals(null)).isFalse();
  }

  @Test
  public void testHashCode() throws Exception {
    //then
    assertThat(location.hashCode()).isNotNull();
  }

  @Test
  public void testToString() throws Exception {
    //then
    assertThat(location.toString()).isEqualTo("42 13");
  }
}