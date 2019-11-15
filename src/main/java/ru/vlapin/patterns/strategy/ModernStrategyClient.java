package ru.vlapin.patterns.strategy;

import java.util.function.ToIntFunction;
import ru.vlapin.patterns.strategy.canonical.Position;

/**
 * @author Vyacheslav Lapin
 */
public class ModernStrategyClient {
  private final ToIntFunction<Position> calculator;

  public ModernStrategyClient(ToIntFunction<Position> calculator) {
    this.calculator = calculator;
  }

  public static void main(String[] args) {
    Position position = new Position(3, 1000);
    new ModernStrategyClient(TrafficCalculationStrategies::calculateTopTrafficOnly).process(position);
    new ModernStrategyClient(TrafficCalculationStrategies::calculateTrafficForPage).process(position);

    // for unit tests
    new ModernStrategyClient(pos -> 15).process(position);
  }

  public void process(Position position) {
    int traffic = calculator.applyAsInt(position);
    System.out.println("Traffic is " + traffic + " for position " + position);
  }
}
