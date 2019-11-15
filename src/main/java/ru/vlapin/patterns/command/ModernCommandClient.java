package ru.vlapin.patterns.command;

import lombok.val;
import ru.vlapin.patterns.command.canonical.Document;

public class ModernCommandClient {
  public static void main(String... __) {
    val editor = new Document();
    val macro = new ModernMacro();

    macro.record(editor::bold)
        .record(editor::italic)
        .record(editor::underline)
        .run();
  }
}
