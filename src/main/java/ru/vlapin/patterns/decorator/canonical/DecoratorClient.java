package ru.vlapin.patterns.decorator.canonical;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DecoratorClient {
  public static void main(String... __) {
    DigitCounter counter = new BenchmarkingDigitCounter(new NaiveDigitCounter());
    int digitsCount = counter.count("fd6j78fh19kj");
    log.info(digitsCount + " digits found");
  }
}
