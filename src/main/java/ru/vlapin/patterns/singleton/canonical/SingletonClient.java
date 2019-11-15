package ru.vlapin.patterns.singleton.canonical;

/**
 * @author Vyacheslav Lapin
 */
public class SingletonClient implements NamedService {
  public static void main(String... __) {
    new SingletonClient().start();
  }

  public void start() {
    ServiceRegistry.getInstance().register(this);
    main();
  }

  @Override
  public String getName() {
    return "MAIN";
  }
}
