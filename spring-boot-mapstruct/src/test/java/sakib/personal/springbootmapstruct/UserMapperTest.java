package sakib.personal.springbootmapstruct;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import sakib.personal.springbootmapstruct.dto.UserDto;
import sakib.personal.springbootmapstruct.entity.Gender;
import sakib.personal.springbootmapstruct.entity.User;
import sakib.personal.springbootmapstruct.entity.mapper.UserMapper;

public class UserMapperTest extends SpringBootMapstructApplicationTests {

	@Test
	@Order(1)
	public void userToUserDto() {
		User user = User.builder()
				.id(1L)
				.name("Jack")
				.age(25)
				.gender(Gender.MALE).build();

		UserDto userDto = UserMapper.INSTANCE.userToUserDto(user);

		assertThat(userDto).isNotNull();
		assertThat(userDto.getName()).isEqualTo(user.getName());
		assertThat(userDto.getAge()).isEqualTo(user.getAge());
		assertThat(userDto.getSex()).isEqualTo(user.getGender().name());
	}

	@Test
	@Order(1)
	public void userDtoToUser() {
		UserDto userDto = UserDto.builder()
				.name("Jack")
				.age(25)
				.sex(Gender.MALE.name()).build();

		User user = UserMapper.INSTANCE.userDtoToUser(userDto);

		assertThat(user).isNotNull();
		assertThat(user.getName()).isEqualTo(userDto.getName());
		assertThat(user.getAge()).isEqualTo(userDto.getAge());
		assertThat(user.getGender().name()).isEqualTo(userDto.getSex());
	}
}
