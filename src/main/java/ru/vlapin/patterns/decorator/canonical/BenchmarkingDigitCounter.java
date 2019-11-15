package ru.vlapin.patterns.decorator.canonical;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class BenchmarkingDigitCounter implements DigitCounter {

  DigitCounter delegate;

  @Override
  public int count(String str) {
    long startTime = System.currentTimeMillis();
    int count = delegate.count(str);
    long endTime = System.currentTimeMillis();
    log.info("Counting took {} ms", endTime - startTime);
    return count;
  }
}
