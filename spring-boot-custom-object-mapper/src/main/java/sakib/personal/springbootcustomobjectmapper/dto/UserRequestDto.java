package sakib.personal.springbootcustomobjectmapper.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sakib.personal.springbootcustomobjectmapper.entity.Gender;
import sakib.personal.springbootcustomobjectmapper.entity.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDto {
	private String name;
	private int age;
	private String gender;

	public static User toDomain(UserRequestDto userRequestDto) {
		return User.builder()
				.id(0L)
				.name(userRequestDto.getName())
				.age(userRequestDto.getAge())
				.gender(Gender.valueOf(userRequestDto.getGender()))
				.build();
	}
}
