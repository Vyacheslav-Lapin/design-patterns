package ru.vlapin.patterns.prototype;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Vyacheslav Lapin
 */
public class StatsProcessor {
  public List<Stats> process(long domainId, List<TrafficStats> stats) {
    Date now = new Date();
    return stats.stream()
               .filter(stat -> stat.getDomainId() == domainId)
               .map(stat -> stat.invert(now))
               .collect(Collectors.toList());
  }
}
