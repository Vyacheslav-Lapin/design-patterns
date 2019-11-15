package ru.vlapin.patterns.adapter.canonical;

import java.util.concurrent.Executor;
import java.util.function.Consumer;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExecutorConsumerAdaptor implements Consumer<Runnable> {
  Executor executor;

  @Override
  public void accept(Runnable task) {
    executor.execute(task);
  }
}
