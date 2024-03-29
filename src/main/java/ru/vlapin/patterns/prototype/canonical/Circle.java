package ru.vlapin.patterns.prototype.canonical;

/**
 * @author Vyacheslav Lapin
 */
public class Circle implements Figure {
  private int radix;

  public Circle(int radix) {
    this.radix = radix;
  }

  public void changeRadix(int delta) {
    radix += delta;
  }

  @Override
  public double getSquare() {
    return Math.PI * radix * radix;
  }

  @Override
  public Circle clone() {
    return new Circle(radix);
  }
}
