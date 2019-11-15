package ru.vlapin.patterns.factorymethod;

import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import ru.vlapin.patterns.factorymethod.canonical.Document;
import ru.vlapin.patterns.factorymethod.canonical.DocumentFactory;
import ru.vlapin.patterns.factorymethod.canonical.JsonDocument;

@Slf4j
public class ModernFactoryMethodClient {

  public static void main(String... __) {
    DocumentFactory factory = JsonDocument::new;
    printUserDetails(factory.create("USER"));

    Function<String, Document> plainFactory = JsonDocument::new;
    printUserDetails(plainFactory.apply("USER"));
  }

  private static void printUserDetails(Document document) {
    document.addField("name", "Mikalai");
    document.addField("surname", "Alimenkou");
    log.info(document.toString());
  }
}
