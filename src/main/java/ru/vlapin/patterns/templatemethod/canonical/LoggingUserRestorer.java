package ru.vlapin.patterns.templatemethod.canonical;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggingUserRestorer extends AbstractUserRestorer {
  @Override
  protected long store(User user) {
    log.info("User is stored: {}", user);
    return System.currentTimeMillis();
  }
}
