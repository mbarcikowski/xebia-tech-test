package info.mathieubarcikowski.mowitnow;

import static info.mathieubarcikowski.mowitnow.Commands.parseCommands;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class SimulationTest {
  private Simulation simulation;

  @Before
  public void setUp() throws Exception {
    Environment environment = new Environment(
      Lawn.parseLawn("1 1"),
      new Mow(Pose.parsePose("0 0 N"), parseCommands("ADADADAD"))
    );
    simulation = new Simulation(environment);

  }

  @Test
  public void testCall() throws Exception {

    //when
    final Collection<Pose> actualPoses = simulation.call();

    //then
    assertThat(actualPoses)
      .hasSize(1)
      .containsExactly(Pose.parsePose("0 0 N"));
  }
}