package mapper;


import static org.junit.Assert.*;

import DTO.C;
import DTO.Cat;
import DTO.Dog;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CatMapperImpl.class})
public class CatMapperTest {

  @Autowired
  private CatMapper catMapper;

  @Test
  public void mapDogToCat() {

    Dog dog = Dog.builder().name("name").type("dog").build();
    Cat expected = catMapper.dogToCat(dog);

    Assertions.assertEquals(expected, Cat.builder().name("name").type("dog").build());

  }

  @Test
  void name() {
    // Given
    Dog dog = Dog.builder().name("name").type("dog").build();

    // When
    Cat expected = catMapper.dogToCatWithParams(dog, "D");

    // Then
    Assertions.assertEquals(expected, Cat.builder().name("name").type("dog").c(C.builder().code("D").build()).build());
  }
}