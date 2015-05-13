package info.mathieubarcikowski.mowitnow;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LawnTest
{

    @Test
    public void testIncludes_with_2_by_2_square() throws Exception
    {
        Lawn lawn = new Lawn(1, 1);

        assertThat(lawn.includes(-1, 0)).isFalse();
        assertThat(lawn.includes(0, -1)).isFalse();

        assertThat(lawn.includes(0, 0)).isTrue();
        assertThat(lawn.includes(1, 0)).isTrue();
        assertThat(lawn.includes(2, 0)).isFalse();

        assertThat(lawn.includes(0, 1)).isTrue();
        assertThat(lawn.includes(1, 1)).isTrue();
        assertThat(lawn.includes(2, 1)).isFalse();

        assertThat(lawn.includes(0, 2)).isFalse();
        assertThat(lawn.includes(1, 2)).isFalse();
        assertThat(lawn.includes(2, 2)).isFalse();
    }

    @Test
    public void testIncludes_with_3_by_3_square() throws Exception
    {
        Lawn lawn = new Lawn(2, 2);

        assertThat(lawn.includes(-1, 0)).isFalse();
        assertThat(lawn.includes(0, -1)).isFalse();

        assertThat(lawn.includes(0, 0)).isTrue();
        assertThat(lawn.includes(1, 0)).isTrue();
        assertThat(lawn.includes(2, 0)).isTrue();
        assertThat(lawn.includes(3, 0)).isFalse();

        assertThat(lawn.includes(0, 1)).isTrue();
        assertThat(lawn.includes(1, 1)).isTrue();
        assertThat(lawn.includes(2, 1)).isTrue();
        assertThat(lawn.includes(3, 1)).isFalse();

        assertThat(lawn.includes(0, 2)).isTrue();
        assertThat(lawn.includes(1, 2)).isTrue();
        assertThat(lawn.includes(2, 2)).isTrue();
        assertThat(lawn.includes(3, 2)).isFalse();

        assertThat(lawn.includes(0, 3)).isFalse();
        assertThat(lawn.includes(1, 3)).isFalse();
        assertThat(lawn.includes(2, 3)).isFalse();
        assertThat(lawn.includes(3, 3)).isFalse();
    }
}
