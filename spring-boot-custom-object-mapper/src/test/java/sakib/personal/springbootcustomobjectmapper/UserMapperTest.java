package sakib.personal.springbootcustomobjectmapper;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import sakib.personal.springbootcustomobjectmapper.dto.UserRequestDto;
import sakib.personal.springbootcustomobjectmapper.entity.Gender;
import sakib.personal.springbootcustomobjectmapper.entity.User;

public class UserMapperTest extends SpringBootCustomObjectMapperApplicationTests {

	@Test
	public void userRequestDtoToUser() {
		UserRequestDto userRequestDto = UserRequestDto.builder()
				.name("Jack")
				.age(25)
				.gender(Gender.MALE.name()).build();

		User user = UserRequestDto.toDomain(userRequestDto);

		assertThat(user).isNotNull();
		assertThat(user.getId()).isEqualTo(0);
		assertThat(user.getName()).isEqualTo(userRequestDto.getName());
		assertThat(user.getAge()).isEqualTo(userRequestDto.getAge());
		assertThat(user.getGender().name()).isEqualTo(userRequestDto.getGender());
	}
}
