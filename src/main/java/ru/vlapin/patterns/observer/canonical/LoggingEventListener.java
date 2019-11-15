package ru.vlapin.patterns.observer.canonical;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggingEventListener implements EventListener {
  @Override
  public void onEvent(Event event) {
    log.info("EVENT: " + event.getName());
  }
}
