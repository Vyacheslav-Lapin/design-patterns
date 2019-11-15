package ru.vlapin.patterns.templatemethod;

import ru.vlapin.patterns.templatemethod.canonical.User;

/**
 * @author Vyacheslav Lapin
 */
public class LoggingUserStorage {
  public long store(User user) {
    System.out.println("User is stored: " + user);
    return System.currentTimeMillis();
  }
}
