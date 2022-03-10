package com.example.demo.service;

import com.example.demo.exception.StartWithZeroException;
import com.example.demo.pojo.NameByWeight;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class MultiplicityService {
  private static final int ZERO = 0;
  private static final IntPredicate by3 = p -> p % 3 == 0;
  private static final IntPredicate by5 = p -> p % 5 == 0;
  private final Map<IntPredicate, NameByWeight> map = new HashMap<>();


  public MultiplicityService() {
    initMap();
  }

  private void initMap() {
    map.put(by3.and(by5), new NameByWeight(2, "Visual Nuts"));
    map.put(by3, new NameByWeight(1, "Visual"));
    map.put(by5, new NameByWeight(1, "Nuts"));
  }

  public List<String> checkNumbersInRange(final int start, final int end) {
    Optional.of(start)
        .filter(s -> s > ZERO)
        .orElseThrow(() -> new StartWithZeroException("The range needs to start at least by 1"));

    return IntStream.rangeClosed(start, end)
        .mapToObj(p -> getMapNameByWight(p).getValue())
        .collect(Collectors.toList());
  }

  private NameByWeight getMapNameByWight(final int p) {
    return map.getOrDefault(
        map.entrySet().stream()
            .filter(pred -> pred.getKey().test(p))
            .max(Comparator.comparingInt(c -> c.getValue().getWeight()))
            .map(Map.Entry::getKey)
            .orElse(null),
        new NameByWeight(0, String.valueOf(p)));
  }
}
