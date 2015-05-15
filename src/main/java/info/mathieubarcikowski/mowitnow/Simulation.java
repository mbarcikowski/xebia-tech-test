package info.mathieubarcikowski.mowitnow;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class Simulation implements Callable<Collection<Pose>>
{
    private final Environment environment;

    public Simulation(Environment anEnvironment)
    {
        environment = anEnvironment;
    }


    @Override
    public Collection<Pose> call() throws Exception
    {
        return environment.getMows()
                          .stream()
                          .map(mow -> {
                              System.out.println(mow);
                              mow.executeProgram(environment);
                              return mow;
                          })
                          .map(mow -> {
                              Pose pose = mow.getPose();
                              System.out.println(pose);
                              return pose;
                          })
                          .collect(Collectors.toList());
    }
}
