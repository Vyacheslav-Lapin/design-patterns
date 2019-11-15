package ru.vlapin.patterns.adapter.canonical;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CharCounterTask implements Runnable {
  String str;
  AtomicInteger counter;

  @Override
  public void run() {
    counter.addAndGet(str.length());
  }
}
