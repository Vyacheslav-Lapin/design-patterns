package ru.vlapin.patterns.iterator.canonical;

import lombok.extern.slf4j.Slf4j;
import lombok.val;

@Slf4j
public class IteratorClient {

  public static void main(String[] args) {
    Text text = new MultilineText("""
                                      This is just
                                      a simple multiline

                                      text

                                      """, "\n");
    LineIterator lineIterator = text.lineIterator();
    String line = lineIterator.nextLine();

    while (line != null) {
      log.info(line);
      line = lineIterator.nextLine();
    }

    String sentence = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
    log.info(capitalize(sentence));
  }

  private static String capitalize(String sentence) {
    String[] words = sentence.split(" ");
    val caps = new StringBuilder();

    for (String word : words)
      if (word.length() > 4)
        caps.append(word.toUpperCase()).append(' ');

    return caps.toString().trim();
  }
}
