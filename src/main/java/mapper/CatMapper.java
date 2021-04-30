package mapper;

import DTO.C;
import DTO.Cat;
import DTO.Dog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(imports = C.class)
public interface CatMapper {

  Cat dogToCat(Dog dog);

  @Mapping( target = "c", expression = "java(C.builder().code(d).build())")
  Cat dogToCatWithParams(Dog dog, String d);

}
