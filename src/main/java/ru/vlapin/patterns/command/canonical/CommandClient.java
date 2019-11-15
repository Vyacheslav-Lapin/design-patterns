package ru.vlapin.patterns.command.canonical;

import lombok.val;

public class CommandClient {
  public static void main(String... __) {
    val editor = new Document();

    val macro = new Macro();
    macro.record(new BoldCommand(editor));
    macro.record(new ItalicCommand(editor));
    macro.record(new UnderlineCommand(editor));
    macro.run();
  }
}
