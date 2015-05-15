package info.mathieubarcikowski.mowitnow;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LocationsTest
{

    @Test
    public void testORIGIN() throws Exception
    {
        //then
        assertThat(Locations.ORIGIN.getX()).isEqualTo(0);
        assertThat(Locations.ORIGIN.getY()).isEqualTo(0);

    }
}