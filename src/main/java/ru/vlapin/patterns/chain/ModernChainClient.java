package ru.vlapin.patterns.chain;

import java.util.function.Consumer;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import ru.vlapin.patterns.chain.canonical.Request;

@Slf4j
public class ModernChainClient {
  public static void main(String... __) {
    val request = new Request(5);
    chain(new ModernAuthRequestHandler(), ModernChainClient::log)
        .accept(request);
  }

  @NotNull
  @SafeVarargs
  public static Consumer<Request> chain(Consumer<Request>... handlers) {
    return Stream.of(handlers)
               .reduce(Consumer::andThen)
               .get();
  }

  private static void log(Request request) {
    log.info("Request arrived: {}", request);
  }
}
