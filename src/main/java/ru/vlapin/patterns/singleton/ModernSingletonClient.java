package ru.vlapin.patterns.singleton;

import ru.vlapin.patterns.singleton.canonical.NamedService;

/**
 * @author Vyacheslav Lapin
 */
public class ModernSingletonClient implements NamedService {
  private final ModernServiceRegistry registry;

  public ModernSingletonClient(ModernServiceRegistry registry) {
    this.registry = registry;
  }

  public static void main(String[] args) {
    ModernServiceRegistry registry = new ModernServiceRegistry();
    new ModernSingletonClient(registry).start();
  }

  public void start() {
    registry.register(this);
  }

  @Override
  public String getName() {
    return "MAIN";
  }
}
