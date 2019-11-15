package ru.vlapin.patterns.command.canonical;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UnderlineCommand implements Command {
  Editor editor;

  @Override
  public void execute() {
    editor.underline();
  }
}
