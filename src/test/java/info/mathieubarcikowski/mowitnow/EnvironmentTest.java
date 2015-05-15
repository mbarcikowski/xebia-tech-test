package info.mathieubarcikowski.mowitnow;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

public class EnvironmentTest {
  private Environment environment;
  private Mow mow;

  @Before
  public void setUp() throws Exception {
    mow = new Mow(Pose.parsePose("0 0 N"), Lists.emptyList());
    environment = new Environment(Lawn.parseLawn("1 1"),
      mow);

  }

  @Test
  public void testIsValidLocation() throws Exception {
    //then
    assertThat(environment.isValidLocation(new Location(-1, 0))).isFalse();
    assertThat(environment.isValidLocation(new Location(0, 0))).isFalse();
    assertThat(environment.isValidLocation(new Location(1, 0))).isTrue();
    assertThat(environment.isValidLocation(new Location(2, 0))).isFalse();
    assertThat(environment.isValidLocation(new Location(0, 1))).isTrue();
    assertThat(environment.isValidLocation(new Location(1, 1))).isTrue();
    assertThat(environment.isValidLocation(new Location(2, 1))).isFalse();
    assertThat(environment.isValidLocation(new Location(1, 2))).isFalse();

  }

  @Test
  public void testGetMows() throws Exception {
    //then
    assertThat(environment.getMows())
      .hasSize(1)
      .containsExactly(mow);
  }
}