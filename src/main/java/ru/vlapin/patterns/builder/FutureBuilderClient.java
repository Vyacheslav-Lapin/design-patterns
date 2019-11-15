package ru.vlapin.patterns.builder;

import lombok.val;

public class FutureBuilderClient {
  public static void main(String... __) {
    val cluster = FutureCluster.builder()
                      .port(3165)
                      .retryAttempts(3)
                      .metricsEnabled(false);
   }
}
