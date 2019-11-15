package ru.vlapin.patterns.singleton;

import org.jetbrains.annotations.Contract;

public class Singleton {

  private static Singleton singleton;

  @Contract(pure = true)
  private Singleton() {
    if (singleton != null)
      throw new UnsupportedOperationException("Already exists!");
  }

  @Contract(pure = true)
  public static Singleton getInstance() {
    if (singleton == null)
      synchronized (Singleton.class) {
        if (singleton == null)
          singleton = new Singleton();
      }
    return singleton;
  }
}
