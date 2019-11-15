package ru.vlapin.patterns.chain.canonical;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

@Slf4j
public class AuthRequestHandler extends AbstractRequestHandler {

  private static final ThreadLocal<Long> CURRENT_USER = new ThreadLocal<>();

  public AuthRequestHandler(RequestHandler next) {
    super(next);
  }

  public static Long getCurrentUser() {
    return CURRENT_USER.get();
  }

  @Override
  public void handleRequest(@NotNull Request request) {
    CURRENT_USER.set(request.getUserId());
    log.info("Current user is set to: " + request.getUserId());
    request.addParam("AUTH_PASSED", "TRUE");
    passToTheNext(request);
  }
}
