package ru.vlapin.patterns.observer.canonical;

import lombok.val;

public class ObserverClient {
  public static void main(String[] args) {
    val server = new TimeServer();
    server.addListener(new LoggingEventListener());
    server.reportTime();
    server.reportTime();
  }
}
