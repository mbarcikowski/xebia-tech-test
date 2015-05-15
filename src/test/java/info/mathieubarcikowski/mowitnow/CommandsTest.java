package info.mathieubarcikowski.mowitnow;

import org.junit.Test;

import java.util.Collection;

import static info.mathieubarcikowski.mowitnow.Commands.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown;

public class CommandsTest
{

    @Test
    public void testParseCommands_with_unique_command_A() throws Exception
    {
        //when
        final Collection<Command> actualCommands = Commands.parseCommands("A");

        //then
        assertThat(actualCommands).hasSize(1);
        assertThat(actualCommands).containsExactly(MOVE_FORWARD);
    }

    @Test
    public void testParseCommands_with_unique_command_G() throws Exception
    {
        //when
        final Collection<Command> actualCommands = Commands.parseCommands("G");

        //then
        assertThat(actualCommands).hasSize(1);
        assertThat(actualCommands).containsExactly(TURN_LEFT);
    }

    @Test
    public void testParseCommands_with_unique_command_D() throws Exception
    {
        //when
        final Collection<Command> actualCommands = Commands.parseCommands("D");

        //then
        assertThat(actualCommands).hasSize(1);
        assertThat(actualCommands).containsExactly(TURN_RIGHT);
    }

    @Test
    public void testParseCommands_with_several_commands_should_respect_order() throws Exception
    {
        //when
        final Collection<Command> actualCommands = Commands.parseCommands("GAGAGAGAA");

        //then
        assertThat(actualCommands).hasSize(9);
        assertThat(actualCommands).containsExactly(TURN_LEFT,
                MOVE_FORWARD, TURN_LEFT, MOVE_FORWARD, TURN_LEFT,
                MOVE_FORWARD, TURN_LEFT, MOVE_FORWARD, MOVE_FORWARD);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseCommands_with_unknown_command_should_throw_an_exception() throws Exception
    {
        //when
        Commands.parseCommands("U");

        //then
        failBecauseExceptionWasNotThrown(IllegalArgumentException.class);
    }

    @Test
    public void testGetSymbol() throws Exception
    {
        //then
        assertThat(MOVE_FORWARD.getSymbol()).isEqualTo('A');
        assertThat(TURN_LEFT.getSymbol()).isEqualTo('G');
        assertThat(TURN_RIGHT.getSymbol()).isEqualTo('D');
    }

    @Test
    public void testToString() throws Exception
    {
        //then
        assertThat(MOVE_FORWARD.toString()).isEqualTo("A");
        assertThat(TURN_LEFT.toString()).isEqualTo("G");
        assertThat(TURN_RIGHT.toString()).isEqualTo("D");
    }

    @Test
    public void testValueOf() throws Exception
    {
        //then
        assertThat(Commands.valueOf("MOVE_FORWARD")).isEqualTo(MOVE_FORWARD);
        assertThat(Commands.valueOf("TURN_LEFT")).isEqualTo(TURN_LEFT);
        assertThat(Commands.valueOf("TURN_RIGHT")).isEqualTo(TURN_RIGHT);
    }
}