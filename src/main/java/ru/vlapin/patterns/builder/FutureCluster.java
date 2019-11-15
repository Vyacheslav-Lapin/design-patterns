package ru.vlapin.patterns.builder;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class FutureCluster {
  String[] hosts;
  int port;
  int retryAttempts;
  boolean metricsEnabled;
}
