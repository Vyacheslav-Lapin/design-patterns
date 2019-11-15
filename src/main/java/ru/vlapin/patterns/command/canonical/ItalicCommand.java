package ru.vlapin.patterns.command.canonical;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ItalicCommand implements Command {
  Editor editor;

  @Override
  public void execute() {
    editor.italic();
  }
}

