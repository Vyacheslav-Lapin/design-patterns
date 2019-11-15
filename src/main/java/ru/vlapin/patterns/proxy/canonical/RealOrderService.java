package ru.vlapin.patterns.proxy.canonical;

/**
 * @author Vyacheslav Lapin
 */
public class RealOrderService implements OrderService {
  @Override
  public void processOrder(Order order) {
    System.out.println("Order processed: " + order);
  }
}
