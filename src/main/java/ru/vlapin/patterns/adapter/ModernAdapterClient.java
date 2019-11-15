package ru.vlapin.patterns.adapter;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import ru.vlapin.patterns.adapter.canonical.CharCounterTask;

@Slf4j
public class ModernAdapterClient {

  @SneakyThrows
  public static void main(String... __) {

    val executorService = Executors.newFixedThreadPool(3);

    val counter = new AtomicInteger();
    Stream.of("af", "bdf", "c")
        .map(s -> new CharCounterTask(s, counter))
        .forEach(executorService::execute);

    executorService.shutdown();
    executorService.awaitTermination(1, SECONDS);
    log.info("Total count: {}", counter.get());
  }
}
