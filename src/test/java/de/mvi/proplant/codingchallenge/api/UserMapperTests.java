package de.mvi.proplant.codingchallenge.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import de.mvi.proplant.codingchallenge.api.model.User;
import de.mvi.proplant.codingchallenge.api.model.dto.UserDto;
import de.mvi.proplant.codingchallenge.api.model.dto.UserMapper;

public class UserMapperTests {
    
    private UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @Test
    public void entityToDto() {

        User user = new User("user123", "carolina","user123@gmail.com");

        UserDto userDto = mapper.userToUserDto(user);

        assertEquals("user123", userDto.getName());
    }

    @Test
    public void dtoToEntity() {

        UserDto userDto = new UserDto();
        userDto.setNachname("user123");


        User user = mapper.userDtoToUser(userDto);

        assertEquals("user123", user.getNachname());
    }
}
