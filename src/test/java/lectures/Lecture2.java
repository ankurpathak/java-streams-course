package lectures;

import beans.Person;
import java.util.List;
import java.util.stream.IntStream;
import mockdata.MockData;
import org.junit.Test;

public class Lecture2 {

  @Test
  public void range() throws Exception {
      IntStream.rangeClosed(1, 10).forEach(System.out::println);



  }

  @Test
  public void rangeIteratingLists() throws Exception {
    List<Person> people = MockData.getPeople();
    IntStream.range(0, people.size())
            .forEach(it -> {
              System.out.println(people.get(it));
            });
  }

  @Test
  public void intStreamIterate() throws Exception {
      IntStream.iterate(2, it -> it + 2).limit(20).forEach(System.out::println);
  }
}
