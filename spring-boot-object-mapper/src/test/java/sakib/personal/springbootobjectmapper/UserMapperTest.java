package sakib.personal.springbootobjectmapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sakib.personal.springbootobjectmapper.dto.UserDto;
import sakib.personal.springbootobjectmapper.entity.Gender;
import sakib.personal.springbootobjectmapper.entity.User;

import static org.assertj.core.api.Assertions.assertThat;

public class UserMapperTest extends SpringBootObjectMapperApplicationTests {

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	@Order(1)
	public void userToUserDto() {
		User user = User.builder()
				.id(1L)
				.name("Jack")
				.age(25)
				.gender(Gender.MALE).build();

		UserDto userDto = objectMapper.convertValue(user, UserDto.class);

		assertThat(userDto).isNotNull();
		assertThat(userDto.getName()).isEqualTo(user.getName());
		assertThat(userDto.getAge()).isEqualTo(user.getAge());
		assertThat(userDto.getGender()).isEqualTo(user.getGender().name());
	}

	@Test
	@Order(1)
	public void userDtoToUser() {
		UserDto userDto = UserDto.builder()
				.name("Jack")
				.age(25)
				.gender(Gender.MALE.name()).build();

		User user = objectMapper.convertValue(userDto, User.class);

		assertThat(user).isNotNull();
		assertThat(user.getName()).isEqualTo(userDto.getName());
		assertThat(user.getAge()).isEqualTo(userDto.getAge());
		assertThat(user.getGender().name()).isEqualTo(userDto.getGender());
	}
}
