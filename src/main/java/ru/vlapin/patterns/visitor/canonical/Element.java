package ru.vlapin.patterns.visitor.canonical;

public interface Element {
  <T> T accept(Visitor<T> visitor);
}
