package ru.vlapin.patterns.chain.canonical;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggingRequestHandler extends AbstractRequestHandler {

  public LoggingRequestHandler(RequestHandler next) {
    super(next);
  }

  @Override
  public void handleRequest(Request request) {
    log.info("Request arrived: {}", request);
    passToTheNext(request);
  }
}
