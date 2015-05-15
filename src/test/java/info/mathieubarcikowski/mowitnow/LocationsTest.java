package info.mathieubarcikowski.mowitnow;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;


public class LocationsTest {

  @Test
  public void testORIGIN() throws Exception {
    //then
    assertThat(Locations.ORIGIN.getCoordinateX()).isEqualTo(0);
    assertThat(Locations.ORIGIN.getCoordinateY()).isEqualTo(0);

  }
}