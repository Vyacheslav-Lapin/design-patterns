package ru.vlapin.patterns.visitor;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import ru.vlapin.patterns.visitor.canonical.Circle;
import ru.vlapin.patterns.visitor.canonical.Rectangle;
import ru.vlapin.patterns.visitor.canonical.Square;

@Slf4j
public class ModernVisitorClient {
  private static final Function<Object, Double> AREA_CALCULATOR = new LambdaVisitor<Double>()
                                                                      .on(Square.class).then(s -> s.getSide() * s.getSide())
                                                                      .on(Circle.class).then(c -> Math.PI * c.getRadius() * c.getRadius())
                                                                      .on(Rectangle.class).then(r -> r.getHeight() * r.getWidth());

  private static final Function<Object, Double> PERIMETER_CALCULATOR = new LambdaVisitor<Double>()
                                                                           .on(Square.class).then(s -> 4 * s.getSide())
                                                                           .on(Circle.class).then(c -> 2 * Math.PI * c.getRadius())
                                                                           .on(Rectangle.class).then(r -> 2 * r.getHeight() + 2 * r.getWidth());

  public static void main(String... __) {
    List<Object> figures = Arrays.asList(new Circle(4), new Square(5), new Rectangle(6, 7));

    double totalArea = figures.stream()
                           .map(AREA_CALCULATOR)
                           .reduce(0.0, Double::sum);

    log.info("Total area = {}", totalArea);

    double totalPerimeter = figures.stream()
                                .map(PERIMETER_CALCULATOR)
                                .reduce(0.0, Double::sum);

    log.info("Total perimeter = {}", totalPerimeter);
  }
}
