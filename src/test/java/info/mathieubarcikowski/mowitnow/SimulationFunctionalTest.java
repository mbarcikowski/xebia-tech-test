package info.mathieubarcikowski.mowitnow;

import org.junit.Test;

import java.util.Collection;

import static info.mathieubarcikowski.mowitnow.Commands.parseCommands;
import static info.mathieubarcikowski.mowitnow.Lawn.parseLawn;
import static info.mathieubarcikowski.mowitnow.Pose.parsePose;
import static org.assertj.core.api.Assertions.assertThat;

public class SimulationFunctionalTest
{

    @Test
    public void testRun() throws Exception
    {
        //given
        Environment environment = new Environment(
                parseLawn("5 5"),
                new Mow(parsePose("1 2 N"),
                        parseCommands("GAGAGAGAA")
                ),
                new Mow(parsePose("3 3 E"),
                        parseCommands("AADAADADDA")
                )
        );

        Simulation simulation = new Simulation(environment);

        //when
        final Collection<Pose> result = simulation.call();

        //then
        assertThat(result)
                .hasSize(2)
                .containsExactly(
                        parsePose("1 3 N"),
                        parsePose("5 1 E")
                );
    }
}