package ru.vlapin.patterns.decorator.canonical;

import org.jetbrains.annotations.NotNull;

public class NaiveDigitCounter implements DigitCounter {

  @Override
  public int count(@NotNull String str) {
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (Character.isDigit(c))
        count++;
    }
    return count;
  }
}
