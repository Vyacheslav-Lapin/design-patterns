package ru.vlapin.patterns.iterator;

import java.util.Arrays;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ModernIteratorClient {
  public static void main(String... __) {
    ModernText text = new ModernMultilineText("""
        This is just
        a simple multiline

        text
        """, "\n");
    text.linesStream().forEach(log::info);

    String sentence = "JEEConf is the oldest Java conference in Ukraine";
    log.info(capitalize(sentence));
  }

  private static String capitalize(String sentence) {
    return Arrays.stream(sentence.split(" "))
               .filter(word -> word.length() > 4)
               .map(String::toUpperCase)
               .collect(Collectors.joining(" "));
  }
}
