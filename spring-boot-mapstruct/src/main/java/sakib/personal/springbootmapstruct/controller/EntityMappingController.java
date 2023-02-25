package sakib.personal.springbootmapstruct.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sakib.personal.springbootmapstruct.dto.UserDto;
import sakib.personal.springbootmapstruct.entity.Gender;
import sakib.personal.springbootmapstruct.entity.User;
import sakib.personal.springbootmapstruct.entity.mapper.UserMapper;

@RestController
@RequestMapping("/entity-mapping")
public class EntityMappingController {

    @GetMapping("/to-dto")
    public UserDto toDto() {
        User user = User.builder()
                .id(1L)
                .name("Jack")
                .age(25)
                .gender(Gender.MALE).build();
        return UserMapper.INSTANCE.userToUserDto(user);
    }

    @GetMapping("/to-entity")
    public User toEntity() {
        UserDto userDto = UserDto.builder()
                .name("Jack")
                .age(25)
                .sex(Gender.MALE.name()).build();
        return UserMapper.INSTANCE.userDtoToUser(userDto);
    }
}
