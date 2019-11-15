package ru.vlapin.patterns.builder.canonical;

public class BuilderClient {

  public static void main(String... __) {

    var cluster = Cluster.runtimeBuilder()
                      .addContactPoints("localhost")
                      .withPort(3165)
                      .withRetryAttempts(3)
                      .withoutMetrics()
                      .build();

    cluster = Cluster.storingBuilder()
                  .hosts(new String[]{"localhost"})
                  .port(3165)
                  .retryAttempts(3)
                  .metricsEnabled(true)
                  .build();
  }
}
