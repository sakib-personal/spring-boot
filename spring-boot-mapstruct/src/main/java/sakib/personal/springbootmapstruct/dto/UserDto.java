package sakib.personal.springbootmapstruct.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private String name;
    private int age;
    private String sex;
}
