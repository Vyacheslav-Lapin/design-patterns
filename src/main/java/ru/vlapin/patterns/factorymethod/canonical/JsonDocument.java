package ru.vlapin.patterns.factorymethod.canonical;

import java.util.LinkedHashMap;
import java.util.Map;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public class JsonDocument implements Document {

  @Getter
  String name;

  Map<String, String> fields = new LinkedHashMap<>();

  @Override
  public void addField(String name, String value) {
    fields.put(name, value);
  }
}
