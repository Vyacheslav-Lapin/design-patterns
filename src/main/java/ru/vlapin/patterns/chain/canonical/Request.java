package ru.vlapin.patterns.chain.canonical;

import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.jetbrains.annotations.Contract;

@Value
@RequiredArgsConstructor
public class Request {
  long userId;
  Map<String, String> params = new HashMap<>();

  @Contract("_, _ -> this")
  public Request addParam(String name, String value) {
    params.put(name, value);
    return this;
  }
}
