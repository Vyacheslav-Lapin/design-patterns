package ru.vlapin.patterns.builder;

import java.util.List;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.Singular;
import lombok.Value;
import lombok.With;

@With
@Value
@Builder(toBuilder = true)
public class Cluster {
  @Singular
  List<String> hosts;

  @Default
  int port = 80;

  int retryAttempts;
  boolean metricsEnabled;
}
