package ru.vlapin.patterns.visitor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

public class LambdaVisitor<A> implements Function<Object, A> {

  Map<Class<?>, Function<Object, A>> functions = new HashMap<>();

  public <B> Acceptor<A, B> on(Class<B> clazz) {
    return new Acceptor<>(this, clazz);
  }

  @Override
  public A apply(@NotNull Object o) {
    return functions.get(o.getClass()).apply(o);
  }

  @RequiredArgsConstructor
  public static class Acceptor<A, B> {
    LambdaVisitor visitor;
    Class<B> clazz;

    public LambdaVisitor<A> then(Function<B, A> f) {
      visitor.functions.put(clazz, f);
      return visitor;
    }
  }
}
