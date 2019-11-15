package ru.vlapin.patterns.prototype.canonical;

/**
 * @author Vyacheslav Lapin
 */
public interface Figure {
  double getSquare();

  Figure clone();
}
