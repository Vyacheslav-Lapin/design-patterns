package ru.vlapin.patterns.builder.canonical;

import static lombok.AccessLevel.PRIVATE;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE)
@Builder(toBuilder = true,
    builderMethodName = "storingBuilder",
    builderClassName = "StoringBuilder")
public class Cluster {

  @NonNull
  String[] hosts;

  @NonNull
  int port;

  int retryAttempts;

  boolean metricsEnabled;

  @NotNull
  @Contract(value = " -> new", pure = true)
  public static RuntimeBuilder runtimeBuilder() {
    return new RuntimeBuilder();
  }

  public static class RuntimeBuilder {
    private Cluster cluster = new Cluster();

    public RuntimeBuilder addContactPoints(String... hosts) {
      if (hosts == null || hosts.length == 0) {
        throw new IllegalArgumentException("Hosts must be set!");
      }
      cluster.setHosts(hosts);
      return this;
    }

    public RuntimeBuilder withPort(int port) {
      cluster.setPort(port);
      return this;
    }

    public RuntimeBuilder withRetryAttempts(int retryAttempts) {
      cluster.setRetryAttempts(retryAttempts);
      return this;
    }

    public RuntimeBuilder withoutMetrics() {
      cluster.setMetricsEnabled(false);
      return this;
    }

    public Cluster build() {
      return cluster;
    }
  }

//  public static StoringBuilder storingBuilder() {
//    return new StoringBuilder();
//  }

//  @Data
//  @Getter(NONE)
//  @Accessors(fluent = true)
//  @FieldDefaults(level = PRIVATE)
//  public static class StoringBuilder {
//    String[] hosts;
//    int port;
//    int retryAttempts;
//    boolean metricsEnabled;
//
//    public Cluster build() {
//      return new Cluster(hosts, port)
//                 .setMetricsEnabled(metricsEnabled)
//                 .setRetryAttempts(retryAttempts);
//    }
//  }
}
