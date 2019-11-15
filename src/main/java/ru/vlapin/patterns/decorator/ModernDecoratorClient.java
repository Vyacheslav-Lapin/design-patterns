package ru.vlapin.patterns.decorator;

import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import ru.vlapin.patterns.decorator.canonical.DigitCounter;
import ru.vlapin.patterns.decorator.canonical.NaiveDigitCounter;

@Slf4j
public class ModernDecoratorClient {

  public static void main(String... __) {
    DigitCounter counter = wrap(new NaiveDigitCounter());

    int digitsCount = counter.count("fd6j78fh19kj");
    log.info("{} digits found", digitsCount);

    digitsCount = ((Function<String, String>) String::trim)
                      .andThen(new NaiveDigitCounter()::count)
                      .apply(" \n 123 \t");

    log.info("{} digits found", digitsCount);
  }

  public static DigitCounter wrap(DigitCounter counter) {
    return s -> {
      long startTime = System.currentTimeMillis();
      int count = counter.count(s);
      long endTime = System.currentTimeMillis();
      log.info("Counting took {} ms", (endTime - startTime));
      return count;
    };
  }
}
