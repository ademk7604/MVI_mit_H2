package de.mvi.proplant.codingchallenge.api.model.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import de.mvi.proplant.codingchallenge.api.model.User;

@Mapper
public interface UserMapper {
    
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);

    List<UserDto> map(List<User> users);
}
