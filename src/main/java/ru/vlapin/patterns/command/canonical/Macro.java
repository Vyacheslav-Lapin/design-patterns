package ru.vlapin.patterns.command.canonical;

import java.util.ArrayList;
import java.util.List;

public class Macro {

  List<Command> commands = new ArrayList<>();

  public void record(Command action) {
    commands.add(action);
  }

  public void run() {
    for (Command command : commands)
      command.execute();
  }
}
