package ru.vlapin.patterns.templatemethod.canonical;

import static lombok.AccessLevel.PRIVATE;

import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = PRIVATE)
public class User {
  Long id;

  @NonNull
  String name;

  @NonNull
  int age;
}
