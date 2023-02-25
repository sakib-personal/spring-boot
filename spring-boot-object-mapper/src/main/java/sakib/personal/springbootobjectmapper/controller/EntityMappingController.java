package sakib.personal.springbootobjectmapper.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sakib.personal.springbootobjectmapper.dto.UserDto;
import sakib.personal.springbootobjectmapper.entity.Gender;
import sakib.personal.springbootobjectmapper.entity.User;

@RestController
@RequiredArgsConstructor
@RequestMapping("/entity-mapping")
public class EntityMappingController {

	private final ObjectMapper objectMapper;

	@GetMapping("/to-dto")
	public UserDto toDto() {
		User user = User.builder()
				.id(1L)
				.name("Jack")
				.age(25)
				.gender(Gender.MALE).build();
		return objectMapper.convertValue(user, UserDto.class);
	}

	@GetMapping("/to-entity")
	public User toEntity() {
		UserDto userDto = UserDto.builder()
				.name("Jack")
				.age(25)
				.gender(Gender.MALE.name()).build();
		return objectMapper.convertValue(userDto, User.class);
	}
}
