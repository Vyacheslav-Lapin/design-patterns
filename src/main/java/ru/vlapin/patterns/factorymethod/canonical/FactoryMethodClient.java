package ru.vlapin.patterns.factorymethod.canonical;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FactoryMethodClient {
  public static void main(String... __) {
    DocumentFactory factory = new JsonDocumentFactory();

    Document document = factory.create("USER");
    document.addField("name", "Vyacheslav");
    document.addField("surname", "Lapin");
    log.info(document.toString());
  }
}
