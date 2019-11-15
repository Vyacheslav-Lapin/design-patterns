package ru.vlapin.patterns.proxy;

import ru.vlapin.patterns.proxy.canonical.Order;

/**
 * @author Vyacheslav Lapin
 */
public class PermissionChecker {
  private final ThreadLocal<Long> currentUser = new ThreadLocal<>();

  public void setCurrentUser(long userId) {
    currentUser.set(userId);
  }

  public void checkPermission(Order order) {
    if (order.getUserId() != currentUser.get()) {
      throw new IllegalStateException("Order for another user can't be processed: " + order);
    }
  }
}
