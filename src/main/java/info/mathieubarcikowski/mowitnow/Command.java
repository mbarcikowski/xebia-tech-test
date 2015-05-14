package info.mathieubarcikowski.mowitnow;

public interface Command
{
    void executeOn(Mow aMow, Environment aEnvironment);
}
