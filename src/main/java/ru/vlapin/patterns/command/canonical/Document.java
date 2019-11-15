package ru.vlapin.patterns.command.canonical;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Document implements Editor {

  @Override
  public void bold() {
    log.info("Bold text...");
  }

  @Override
  public void italic() {
    log.info("Italic text...");
  }

  @Override
  public void underline() {
    log.info("Underline text...");
  }
}
