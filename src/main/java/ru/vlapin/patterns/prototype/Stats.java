package ru.vlapin.patterns.prototype;

import java.util.Date;

/**
 * @author Vyacheslav Lapin
 */
public interface Stats<S> {
  S add(S delta);

  S invert(Date forDate);
}
