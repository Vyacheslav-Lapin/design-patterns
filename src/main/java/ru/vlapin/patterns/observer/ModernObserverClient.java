package ru.vlapin.patterns.observer;

import ru.vlapin.patterns.observer.canonical.Event;

/**
 * @author Vyacheslav Lapin
 */
public class ModernObserverClient {
  public static void main(String[] args) {
    ModernTimeServer server = new ModernTimeServer();
    server.addListener(ModernObserverClient::log);
    server.addListener(e -> System.out.println("ANOTHER EVENT: " + e.getName()));
    server.reportTime();
    server.reportTime();
  }

  public static void log(Event event) {
    System.out.println("EVENT: " + event.getName());
  }
}
