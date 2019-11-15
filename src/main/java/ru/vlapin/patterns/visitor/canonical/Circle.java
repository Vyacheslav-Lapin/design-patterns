package ru.vlapin.patterns.visitor.canonical;

import lombok.Value;
import org.jetbrains.annotations.NotNull;

@Value
public class Circle implements Element {
  double radius;

  @Override
  public <T> T accept(@NotNull Visitor<T> visitor) {
    return visitor.visit(this);
  }
}
