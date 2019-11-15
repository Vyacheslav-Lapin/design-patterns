package ru.vlapin.patterns.chain.canonical;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractRequestHandler implements RequestHandler {
  RequestHandler next;

  protected void passToTheNext(Request request) {
    if (next != null)
      next.handleRequest(request);
  }
}
