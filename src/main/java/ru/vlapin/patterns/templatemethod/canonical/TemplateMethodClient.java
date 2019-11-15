package ru.vlapin.patterns.templatemethod.canonical;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TemplateMethodClient {
  public static void main(String[] args) {
    User user = new LoggingUserRestorer().restore("Vyacheslav:36");
    log.info("Vyacheslav is restored: {}", user);
  }
}
