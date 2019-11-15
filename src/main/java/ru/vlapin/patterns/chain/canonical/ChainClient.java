package ru.vlapin.patterns.chain.canonical;

import lombok.val;

public class ChainClient {
  public static void main(String... __) {
    val request = new Request(5);
    RequestHandler handler = new AuthRequestHandler(new LoggingRequestHandler(null));
    handler.handleRequest(request);
  }
}
