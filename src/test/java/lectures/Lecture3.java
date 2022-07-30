package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import org.junit.Test;

public class Lecture3 {

  @Test
  public void min() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);
    numbers.stream()
            .min(Comparator.naturalOrder())
            .ifPresent(System.out::println);
  }

  @Test
  public void max() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);
    numbers.stream()
            .mapToInt(Integer::intValue)
            .max()
            .ifPresent(System.out::println);
  }
}
