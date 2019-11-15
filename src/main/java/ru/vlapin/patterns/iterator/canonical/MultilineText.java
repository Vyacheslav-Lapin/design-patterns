package ru.vlapin.patterns.iterator.canonical;

import lombok.RequiredArgsConstructor;
import lombok.experimental.NonFinal;

@RequiredArgsConstructor
public class MultilineText implements Text {
  String text;
  String lineSeparator;

  @Override
  public LineIterator lineIterator() {
    return new SeparatorBasedLineIterator();
  }

  private class SeparatorBasedLineIterator implements LineIterator {

    @NonFinal
    int lineStartIndex = 0;

    @Override
    public String nextLine() {
      if (lineStartIndex >= text.length()) return null;

      int separatorIndex = text.indexOf(lineSeparator, lineStartIndex + 1);

      if (separatorIndex < 0) separatorIndex = text.length() - 1;

      String line = text.substring(lineStartIndex, separatorIndex);
      lineStartIndex = separatorIndex + 1;
      return line;
    }
  }
}
