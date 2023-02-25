package sakib.personal.springbootmapstruct.entity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import sakib.personal.springbootmapstruct.dto.UserDto;
import sakib.personal.springbootmapstruct.entity.User;

@Mapper
public interface UserMapper {
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	@Mapping(source = "gender", target = "sex")
	UserDto userToUserDto(User user);

	@Mapping(source = "sex", target = "gender")
	User userDtoToUser(UserDto userDto);
}
