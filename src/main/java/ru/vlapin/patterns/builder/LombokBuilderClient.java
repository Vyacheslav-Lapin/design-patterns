package ru.vlapin.patterns.builder;

import lombok.val;

public class LombokBuilderClient {
  public static void main(String... __) {
    val cluster = Cluster.builder()
                      .host("localhost")
                      .port(3165)
                      .retryAttempts(3)
                      .metricsEnabled(false)
                      .build();
  }
}
