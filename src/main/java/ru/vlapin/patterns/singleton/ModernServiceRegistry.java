package ru.vlapin.patterns.singleton;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import ru.vlapin.patterns.singleton.canonical.NamedService;

/**
 * @author Vyacheslav Lapin
 */
public class ModernServiceRegistry {
  private final ConcurrentMap<String, NamedService> services = new ConcurrentHashMap<>();

  public void register(NamedService service) {
    String name = service.getName();
    System.out.println("Register service with name: " + name);
    services.put(name, service);
  }

  public NamedService getService(String name) {
    return services.get(name);
  }
}
