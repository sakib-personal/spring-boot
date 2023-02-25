package sakib.personal.springbootcustomobjectmapper.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sakib.personal.springbootcustomobjectmapper.dto.UserRequestDto;
import sakib.personal.springbootcustomobjectmapper.entity.Gender;
import sakib.personal.springbootcustomobjectmapper.entity.User;

@RestController
@RequestMapping("/entity-mapping")
public class EntityMappingController {

	@GetMapping("/to-entity")
	public User toEntity() {
		UserRequestDto userRequestDto = UserRequestDto.builder()
				.name("Jack")
				.age(25)
				.gender(Gender.MALE.name()).build();
		return UserRequestDto.toDomain(userRequestDto);
	}
}
