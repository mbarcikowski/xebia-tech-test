package info.mathieubarcikowski.mowitnow;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PoseTest
{
    private Pose pose;

    @Before
    public void setUp() throws Exception
    {
        pose = new Pose(new Location(0, 0), Orientation.NORTH);

    }

    @Test
    public void testParsePose() throws Exception
    {
        //when
        Pose actualPose = Pose.parsePose("0 0 N");

        //then
        assertThat(actualPose).isEqualTo(pose);
    }

    @Test
    public void testGetLocation() throws Exception
    {
        //then
        assertThat(pose.getLocation()).isEqualTo(new Location(0, 0));
    }

    @Test
    public void testGetOrientation() throws Exception
    {
        //then
        assertThat(pose.getOrientation()).isEqualTo(Orientation.NORTH);
    }

    @Test
    public void testEquals() throws Exception
    {
        //then
        assertThat(pose.equals(pose)).isTrue();
        assertThat(pose.equals(new Pose(new Location(0, 0), Orientation.NORTH))).isTrue();
        assertThat(pose.equals(new Pose(new Location(0, 0), Orientation.EAST))).isFalse();
        assertThat(pose.equals(new Pose(new Location(1, 0), Orientation.NORTH))).isFalse();
        assertThat(pose.equals(new Pose(new Location(0, 1), Orientation.NORTH))).isFalse();
        assertThat(pose.equals(new Object())).isFalse();
        assertThat(pose.equals(null)).isFalse();
    }

    @Test
    public void testHashCode() throws Exception
    {
        //then
        assertThat(pose.hashCode()).isNotNull();
    }

    @Test
    public void testToString() throws Exception
    {
        //then
        assertThat(pose.toString()).isEqualTo("0 0 N");
    }
}