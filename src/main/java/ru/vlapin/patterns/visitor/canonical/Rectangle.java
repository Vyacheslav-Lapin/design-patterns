package ru.vlapin.patterns.visitor.canonical;

import lombok.Value;

@Value
public class Rectangle implements Element {
  double width;
  double height;

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visit(this);
  }
}
