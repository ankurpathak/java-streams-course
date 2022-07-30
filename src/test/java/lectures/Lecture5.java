package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();

  }

  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();
        people.stream().map(PersonDTO::map)
                .forEach(System.out::println);
  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
      MockData.getCars().stream().map(Car::getPrice)
              .mapToDouble(Double::doubleValue)
              .average()
              .ifPresent(System.out::println);
  }

  @Test
  public void test() throws Exception {

  }
}



