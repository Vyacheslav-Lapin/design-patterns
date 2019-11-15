package ru.vlapin.patterns.observer;

import java.util.function.Consumer;
import ru.vlapin.patterns.observer.canonical.Event;

/**
 * @author Vyacheslav Lapin
 */
public interface ModernObserver {
  void addListener(Consumer<Event> listener);
}
