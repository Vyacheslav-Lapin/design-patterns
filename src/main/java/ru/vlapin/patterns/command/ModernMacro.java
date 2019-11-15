package ru.vlapin.patterns.command;

import java.util.ArrayList;
import java.util.List;
import ru.vlapin.patterns.command.canonical.Command;

public class ModernMacro {

  List<Command> commands = new ArrayList<>();

  public ModernMacro record(Command action) {
    commands.add(action);
    return this;
  }

  public void run() {
    commands.forEach(Command::execute);
  }
}
