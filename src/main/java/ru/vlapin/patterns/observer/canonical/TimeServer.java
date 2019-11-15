package ru.vlapin.patterns.observer.canonical;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.val;

public class TimeServer implements Observer {

  private static final String TIME_FORMAT = "HH:mm:ss";

  List<EventListener> listeners = new ArrayList<>();

  @Override
  public void addListener(EventListener listener) {
    listeners.add(listener);
  }

  public void reportTime() {
    val event = new Event(
        new SimpleDateFormat(TIME_FORMAT)
            .format(new Date()));

    for (EventListener listener : listeners)
      listener.onEvent(event);
  }
}
