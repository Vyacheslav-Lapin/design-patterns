package ru.vlapin.patterns.proxy;

import java.util.function.Consumer;
import ru.vlapin.patterns.proxy.canonical.Order;
import ru.vlapin.patterns.proxy.canonical.RealOrderService;

/**
 * @author Vyacheslav Lapin
 */
public class ModernProxyClient {
  public static void main(String[] args) {
    Order order = new Order(5L);
    order.putItem("XP", 2);

    RealOrderService service = new RealOrderService();
    PermissionChecker checker = new PermissionChecker();
    Consumer<Order> processing = ((Consumer<Order>) checker::checkPermission)
                                     .andThen(service::processOrder);

    checker.setCurrentUser(5);
    processing.accept(order);
    checker.setCurrentUser(2);
    processing.accept(order);
  }
}
