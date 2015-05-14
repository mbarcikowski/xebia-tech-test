package info.mathieubarcikowski.mowitnow;

import org.junit.Test;

import static info.mathieubarcikowski.mowitnow.Positions.ORIGIN;
import static org.assertj.core.api.Assertions.assertThat;

public class LawnTest
{

    @Test
    public void testIncludes_with_2_by_2_square() throws Exception
    {
        Position northEast = new Position(1,1);
        Lawn lawn = new Lawn(ORIGIN, northEast);

        assertThat(lawn.includes(new Position(-1, 0))).isFalse();
        assertThat(lawn.includes(new Position(0, -1))).isFalse();

        assertThat(lawn.includes(new Position(0, 0))).isTrue();
        assertThat(lawn.includes(new Position(1, 0))).isTrue();
        assertThat(lawn.includes(new Position(2, 0))).isFalse();

        assertThat(lawn.includes(new Position(0, 1))).isTrue();
        assertThat(lawn.includes(new Position(1, 1))).isTrue();
        assertThat(lawn.includes(new Position(2, 1))).isFalse();

        assertThat(lawn.includes(new Position(0, 2))).isFalse();
        assertThat(lawn.includes(new Position(1, 2))).isFalse();
        assertThat(lawn.includes(new Position(2, 2))).isFalse();
    }

    @Test
    public void testIncludes_with_3_by_3_square() throws Exception
    {
        Position northEast = new Position(2,2);
        Lawn lawn = new Lawn(ORIGIN, northEast);

        assertThat(lawn.includes(new Position(-1, 0))).isFalse();
        assertThat(lawn.includes(new Position(0, -1))).isFalse();

        assertThat(lawn.includes(new Position(0, 0))).isTrue();
        assertThat(lawn.includes(new Position(1, 0))).isTrue();
        assertThat(lawn.includes(new Position(2, 0))).isTrue();
        assertThat(lawn.includes(new Position(3, 0))).isFalse();

        assertThat(lawn.includes(new Position(0, 1))).isTrue();
        assertThat(lawn.includes(new Position(1, 1))).isTrue();
        assertThat(lawn.includes(new Position(2, 1))).isTrue();
        assertThat(lawn.includes(new Position(3, 1))).isFalse();

        assertThat(lawn.includes(new Position(0, 2))).isTrue();
        assertThat(lawn.includes(new Position(1, 2))).isTrue();
        assertThat(lawn.includes(new Position(2, 2))).isTrue();
        assertThat(lawn.includes(new Position(3, 2))).isFalse();

        assertThat(lawn.includes(new Position(0, 3))).isFalse();
        assertThat(lawn.includes(new Position(1, 3))).isFalse();
        assertThat(lawn.includes(new Position(2, 3))).isFalse();
        assertThat(lawn.includes(new Position(3, 3))).isFalse();
    }
}
