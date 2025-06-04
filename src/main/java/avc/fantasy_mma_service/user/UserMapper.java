package avc.fantasy_mma_service.user;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "budget", ignore = true)
    User toEntity(CreationEditUserDto creationEditUserDto);

    UserDto toDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "budget", ignore = true)
    void updateUserFromDto(CreationEditUserDto creationEditUserDto, @MappingTarget User user);

    List<UserDto> toDtoList(List<User> users);
}
