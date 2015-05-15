package info.mathieubarcikowski.mowitnow;

public interface Command {
  char getSymbol();

  void executeOn(Mow mow, Environment environment);
}
