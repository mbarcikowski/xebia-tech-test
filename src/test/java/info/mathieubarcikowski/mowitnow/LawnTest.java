package info.mathieubarcikowski.mowitnow;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LawnTest
{

    @Test
    public void testIncludes_with_2_by_2_square() throws Exception
    {
        //given
        Location northEast = new Location(1,1);
        Lawn lawn = new Lawn(northEast);

        //then
        assertThat(lawn.includes(new Location(-1, 0))).isFalse();
        assertThat(lawn.includes(new Location(0, -1))).isFalse();

        assertThat(lawn.includes(new Location(0, 0))).isTrue();
        assertThat(lawn.includes(new Location(1, 0))).isTrue();
        assertThat(lawn.includes(new Location(2, 0))).isFalse();

        assertThat(lawn.includes(new Location(0, 1))).isTrue();
        assertThat(lawn.includes(new Location(1, 1))).isTrue();
        assertThat(lawn.includes(new Location(2, 1))).isFalse();

        assertThat(lawn.includes(new Location(0, 2))).isFalse();
        assertThat(lawn.includes(new Location(1, 2))).isFalse();
        assertThat(lawn.includes(new Location(2, 2))).isFalse();
    }

    @Test
    public void testIncludes_with_3_by_3_square() throws Exception
    {
        //given
        Location northEast = new Location(2,2);
        Lawn lawn = new Lawn(northEast);

        //then
        assertIncludesFor3By3Lawn(lawn);
    }

    @Test
    public void testParseLawn() throws Exception
    {
        //given
        Lawn lawn = Lawn.parseLawn("2 2");

        //then
        assertIncludesFor3By3Lawn(lawn);
    }

    private void assertIncludesFor3By3Lawn(Lawn aLawn)
    {
        assertThat(aLawn.includes(new Location(-1, 0))).isFalse();
        assertThat(aLawn.includes(new Location(0, -1))).isFalse();

        assertThat(aLawn.includes(new Location(0, 0))).isTrue();
        assertThat(aLawn.includes(new Location(1, 0))).isTrue();
        assertThat(aLawn.includes(new Location(2, 0))).isTrue();
        assertThat(aLawn.includes(new Location(3, 0))).isFalse();

        assertThat(aLawn.includes(new Location(0, 1))).isTrue();
        assertThat(aLawn.includes(new Location(1, 1))).isTrue();
        assertThat(aLawn.includes(new Location(2, 1))).isTrue();
        assertThat(aLawn.includes(new Location(3, 1))).isFalse();

        assertThat(aLawn.includes(new Location(0, 2))).isTrue();
        assertThat(aLawn.includes(new Location(1, 2))).isTrue();
        assertThat(aLawn.includes(new Location(2, 2))).isTrue();
        assertThat(aLawn.includes(new Location(3, 2))).isFalse();

        assertThat(aLawn.includes(new Location(0, 3))).isFalse();
        assertThat(aLawn.includes(new Location(1, 3))).isFalse();
        assertThat(aLawn.includes(new Location(2, 3))).isFalse();
        assertThat(aLawn.includes(new Location(3, 3))).isFalse();
    }
}
