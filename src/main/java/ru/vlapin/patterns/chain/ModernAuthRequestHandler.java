package ru.vlapin.patterns.chain;

import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import ru.vlapin.patterns.chain.canonical.Request;

@Slf4j
public class ModernAuthRequestHandler implements Consumer<Request> {

  private static final ThreadLocal<Long> CURRENT_USER = new ThreadLocal<>();

  public static Long getCurrentUser() {
    return CURRENT_USER.get();
  }

  @Override
  public void accept(@NotNull Request request) {
    CURRENT_USER.set(request.getUserId());
    log.info("Current user is set to: {}", request.getUserId());
    request.addParam("AUTH_PASSED", "TRUE");
  }
}
