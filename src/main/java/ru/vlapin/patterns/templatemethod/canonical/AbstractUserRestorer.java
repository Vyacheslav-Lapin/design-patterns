package ru.vlapin.patterns.templatemethod.canonical;

import java.util.StringTokenizer;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractUserRestorer {
  private static final String DELIMITER = ":";

  @NotNull
  public final User restore(String serialized) {
    var tokenizer = new StringTokenizer(serialized, DELIMITER);
    validate(tokenizer);
    User user = parse(tokenizer);
    long id = store(user);
    user.setId(id);
    return user;
  }

  @NotNull
  private User parse(@NotNull StringTokenizer tokenizer) {
    String name = tokenizer.nextToken();
    int age = Integer.parseInt(tokenizer.nextToken());
    return new User(name, age);
  }

  private void validate(@NotNull StringTokenizer tokenizer) {
    if (tokenizer.countTokens() != 2) {
      throw new IllegalArgumentException("Invalid data format!");
    }
  }

  protected abstract long store(User user);
}
