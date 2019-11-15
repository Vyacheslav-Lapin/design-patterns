package ru.vlapin.patterns.command.canonical;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BoldCommand implements Command {
  Editor editor;

  @Override
  public void execute() {
    editor.bold();
  }
}
