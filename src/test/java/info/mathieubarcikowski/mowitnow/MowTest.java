package info.mathieubarcikowski.mowitnow;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MowTest
{

    private Mow mow;

    @Before
    public void setUp() throws Exception
    {
        mow = new Mow(Pose.parsePose("0 0 N"), Lists.emptyList());
    }

    @Test
    public void testSetLocation() throws Exception
    {
        //given
        assertThat(mow.getPose()
                      .getLocation()).isEqualTo(new Location(0, 0));

        //when
        mow.setLocation(new Location(1, 1));

        //then
        assertThat(mow.getPose()
                      .getLocation()).isEqualTo(new Location(1, 1));
    }

    @Test
    public void testGetOrientation() throws Exception
    {
        //then
        assertThat(mow.getOrientation()).isEqualTo(Orientation.NORTH);
    }

    @Test
    public void testSetOrientation() throws Exception
    {
        //given
        assertThat(mow.getOrientation()).isEqualTo(Orientation.NORTH);

        //when
        mow.setOrientation(Orientation.EAST);

        //then
        assertThat(mow.getOrientation()).isEqualTo(Orientation.EAST);
    }

    @Test
    public void testGetFutureLocation() throws Exception
    {
        //given
        assertThat(mow.getPose()
                      .getLocation()).isEqualTo(new Location(0, 0));
        assertThat(mow.getOrientation()).isEqualTo(Orientation.NORTH);

        //when
        final Location actualFutureLocation = mow.getFutureLocation();

        //then
        assertThat(actualFutureLocation).isEqualTo(new Location(0, 1));

    }

    @Test
    public void testOverlaps() throws Exception
    {
        //then
        assertThat(mow.overlaps(new Location(0, 0))).isTrue();
        assertThat(mow.overlaps(new Location(0, 1))).isFalse();
    }

    @Test
    public void testExecuteProgram_with_available_location_should_move_mow() throws Exception
    {
        //given
        mow = new Mow(Pose.parsePose("0 0 N"), Commands.parseCommands("AGG"));
        Environment environment = new Environment(Lawn.parseLawn("1 1"), mow);

        //then
        final Mow actualMow = this.mow.executeProgram(environment);
        final Pose actualPose = actualMow.getPose();

        //then
        assertThat(actualPose.getLocation()).isEqualTo(new Location(0, 1));
        assertThat(actualPose.getOrientation()).isEqualTo(Orientation.SOUTH);
    }

    @Test
    public void testExecuteProgram_with_unavailable_location_should_move_mow() throws Exception
    {
        //given
        mow = new Mow(Pose.parsePose("0 0 N"), Commands.parseCommands("AGG"));
        Mow mow2 = new Mow(Pose.parsePose("0 1 N"), Commands.parseCommands(""));
        Environment environment = new Environment(Lawn.parseLawn("1 1"), mow, mow2);

        //then
        final Mow actualMow = this.mow.executeProgram(environment);
        final Pose actualPose = actualMow.getPose();

        //then
        assertThat(actualPose.getLocation()).isEqualTo(new Location(0, 0));
        assertThat(actualPose.getOrientation()).isEqualTo(Orientation.SOUTH);
    }

    @Test
    public void testGetPose() throws Exception
    {
        //when
        final Pose actualPose = mow.getPose();

        //then
        assertThat(actualPose.getLocation()).isEqualTo(new Location(0, 0));
        assertThat(actualPose.getOrientation()).isEqualTo(Orientation.NORTH);
    }

    @Test
    public void testToString() throws Exception
    {
        assertThat(mow.toString()).isEqualTo("0 0 N, []");
    }
}