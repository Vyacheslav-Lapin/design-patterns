package ru.vlapin.patterns.visitor.canonical;

import lombok.Value;

@Value
public class Square implements Element {
  double side;

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visit(this);
  }
}
